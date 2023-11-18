package com.musalasoft.droneservice.Service;

import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.Medication2;
import com.musalasoft.droneservice.Models.State;
import com.musalasoft.droneservice.Repo.DroneRepo;
import com.musalasoft.droneservice.dtos.DroneRespnse;
import com.musalasoft.droneservice.utils.ScheduledTasks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.naming.LimitExceededException;
@Slf4j
@Service
public class DroneServiceImpl2 implements DroneService{
    @Autowired
    private DroneRepo droneRepo;
    @Autowired
    private MedicationService medicationService;
    @Override
    public Drone registerDrone(Drone drone) {
       
        return droneRepo.save(drone);
    }

    @Override
    public DroneRespnse loadDroneWithMedicationItems(String droneSerialNumber, List<Medication2> medications) {
       medicationService.saveAllMedications(medications);
        Optional<Drone>optional = droneRepo.findById(droneSerialNumber);
        if(optional.isPresent()){
            Drone drone = optional.get();

            medications.stream().forEach(x->{
                if((isDroneAvailableForLoading(drone.getSerialNumber()))) {
                    drone.setState(State.LOADING);
                    drone.getMedications().add(x);
                    drone.setWeight(drone.getWeight() + x.getWeight());
                    if(drone.getWeight() >= 500){
                        drone.setState(State.LOADED);

                    }


                }else log.info("Drone with serial number {} not available", drone.getSerialNumber());
            });
            droneRepo.save(drone);
        }
        else throw new NullPointerException("drone with id "+droneSerialNumber+" not found");
        DroneRespnse respnse = new DroneRespnse();
        respnse.setSerialNumber(optional.get().getSerialNumber());
        respnse.setBatteryCapacity(optional.get().getBatteryCapacity());
        respnse.setState(optional.get().getState());
        respnse.setModel(optional.get().getModel());
        respnse.setMedications(optional.get().getMedications());
        respnse.setWeight(optional.get().getWeight());

        return respnse;
    }

    

    @Override
    public List<Medication2> viewDroneMedicationItems(String droneSerialNumber) {
        Optional <Drone> optional = droneRepo.findById(droneSerialNumber);
        if(!optional.isPresent()){
            throw new NullPointerException("drone with id "+droneSerialNumber+" not found");
        }
            Drone drone = optional.get();
            return drone.getMedications();
    }

    @Override
    public Drone findDroneBySerialNumber(String droneSerialNumber) {
        Optional<Drone>optional = droneRepo.findById(droneSerialNumber);
        if(optional.isPresent())
            return optional.get();
        else throw new NullPointerException("drone with id "+droneSerialNumber+" not found");

    }

    public boolean isDroneAvailableForLoading(String serialNumber){
        if(getDroneWeight(serialNumber) >= 500 || checkDroneBatteryLevel(serialNumber) < 25) {
            log.info("Please check drone limit capacity and/or battery level");
            return false;
        }
        return true;
    }
    public int checkDroneBatteryLevel(String serialNumber){
        return getDroneBatteryLevel(serialNumber);
       // log.info("Drone with serial number {} has a battery level of {}", drone.getSerialNumber(), batteryCapacity);

    }
    public Integer getDroneWeight(String serialNumber){
        Optional<Drone> optional = droneRepo.findById(serialNumber);
      return optional.get().getWeight();
    }

    public int getDroneBatteryLevel(String serialNumber){
        Optional <Drone>optional = droneRepo.findById(serialNumber);
        if(optional.isPresent()){
            Drone drone = optional.get();
        String batteryLevel = drone.getBatteryCapacity().substring(0, drone.getBatteryCapacity().length()-1);
         return  Integer.parseInt(batteryLevel);
        }
        else throw new NullPointerException("drone with serial number "+ serialNumber + " not found");
    }

    
    

    @Override
    public List<Drone> getAllDrones() {
       
        return droneRepo.findAll();
       
    }

    @Override
    public List<DroneRespnse> checkAvailaDronesForLoading() {
        // TODO Auto-generated method stub
        List<Drone>drones = droneRepo.findAll();
        List<DroneRespnse> respnses =  drones.stream().filter(drone -> drone.getState().equals(State.IDLE) || drone.getState().equals(State.LOADING))
        .map(drone -> new DroneRespnse(drone.getSerialNumber(), drone.getWeight(), drone.getBatteryCapacity(), drone.getState(), drone.getModel())).toList();
        return respnses;
        
    }

    @Override
    public String checkDroneBatteryLevelForDrone(String serialNumber) {
        // TODO Auto-generated method stub
        
        return String.valueOf(checkDroneBatteryLevel(serialNumber)) +"%";
        
    }

}
