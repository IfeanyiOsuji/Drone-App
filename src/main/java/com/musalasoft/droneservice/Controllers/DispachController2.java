package com.musalasoft.droneservice.Controllers;

import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.Medication2;
import com.musalasoft.droneservice.Service.DroneService;
import com.musalasoft.droneservice.dtos.DroneRespnse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/DroneService")
public class DispachController2 {
    @Autowired
    private DroneService droneService;
    @PostMapping("/register")
    public ResponseEntity registerDrone(@RequestBody Drone drone){
       Drone drone2 =  droneService.registerDrone(drone);
        return new ResponseEntity<Drone>((drone2), null, HttpStatus.CREATED);
    }
    @PutMapping("/loadMedications/id/{id}")
    public ResponseEntity<DroneRespnse> loadDroneWithMedicationItems(@PathVariable Long id, @RequestBody List<Medication2> medication2List){
       DroneRespnse respnse= droneService.loadDroneWithMedicationItems(id, medication2List);
       return new ResponseEntity<DroneRespnse>((respnse), null, HttpStatus.OK);
    }

}
