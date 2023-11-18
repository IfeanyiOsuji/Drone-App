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
                if((isDroneAvailableForLoading(drone))) {
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

    public boolean isDroneAvailableForLoading(Drone drone){
        if(getDroneWeight(drone) >= 500 || checkDroneBatteryLevel(drone) < 25) {
            log.info("Please check drone limit capacity and/or battery level");
            return false;
        }
        return true;
    }
    public int checkDroneBatteryLevel(Drone drone){
        return getDroneBatteryLevel(drone);
       // log.info("Drone with serial number {} has a battery level of {}", drone.getSerialNumber(), batteryCapacity);

    }
    public Integer getDroneWeight(Drone drone){
      return drone.getWeight();
    }

    public int getDroneBatteryLevel(Drone drone){
        Optional optional = droneRepo.findById(drone.getSerialNumber());
        if(optional.isPresent()){
        String batteryLevel = drone.getBatteryCapacity().substring(0, drone.getBatteryCapacity().length()-1);
         return  Integer.parseInt(batteryLevel);
        }
        else throw new NullPointerException("drone with serial number "+ drone.getSerialNumber() + " not found");
    }

    // public void setDroneBatteryLimit(Drone drone){
    //     //Calendar now = Calendar.getInstance();
    //     while(getDroneBatteryLevel(drone) > 0){
    //         try {
    //             if (drone.getState().equals(State.IDLE)) {
    //                 Thread.sleep(50000000);
    //                 drone.setBatteryCapacity(getDroneBatteryLevel(drone) - 1);
    //             }
    //             if (drone.getState().equals(State.LOADING)) {
    //                 Thread.sleep(5000);
    //                 drone.setBatteryCapacity(getDroneBatteryLevel(drone) - 3);
    //             }
    //             if (drone.getState().equals(State.LOADED)) {
    //                 Thread.sleep(5000);
    //                 drone.setBatteryCapacity(getDroneBatteryLevel(drone) - 4);
    //             }
    //             droneRepo.save(drone);
    //         }catch (Exception ex){}
    //     }
    //     ScheduledTasks task= new ScheduledTasks(drone);
    //     task.reportDroneBatteryCapacity();
    // }
    

    @Override
    public List<Drone> getAllDrones() {
        // TODO Auto-generated method stub
        return droneRepo.findAll();
       // throw new UnsupportedOperationException("Unimplemented method 'getAllDrones'");
    }

}
