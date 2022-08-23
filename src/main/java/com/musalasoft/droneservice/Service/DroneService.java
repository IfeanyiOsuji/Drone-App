package com.musalasoft.droneservice.Service;

import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.Medication2;
import com.musalasoft.droneservice.dtos.DroneRespnse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DroneService {
    public Drone registerDrone(Drone drone);
    public DroneRespnse loadDroneWithMedicationItems(Long droneId, List<Medication2> medications);
    public List<Medication2> viewDroneMedicationItems(Long droneId);
    public Drone findDroneBySerialNumber(Long droneId);

}
