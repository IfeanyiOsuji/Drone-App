package com.musalasoft.droneservice.Service;

import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.Medication2;
import com.musalasoft.droneservice.dtos.DroneRespnse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DroneService {
    public Drone registerDrone(Drone drone);
    public DroneRespnse loadDroneWithMedicationItems(String droneId, List<Medication2> medications);
    public List<Medication2> viewDroneMedicationItems(String droneId);
    public Drone findDroneBySerialNumber(String droneId);
    public List<Drone> getAllDrones();
    //public void setDroneBatteryLimit(Drone drone);

}
