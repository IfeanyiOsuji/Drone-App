//package com.musalasoft.droneservice.Controllers;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.musalasoft.droneservice.Models.Drones;
//import com.musalasoft.droneservice.Models.LoadingBayVM;
//import com.musalasoft.droneservice.Models.MedicationLoaderWrapper;
//import com.musalasoft.droneservice.Service.IDroneService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/DroneService")
//public class DispatchController {
//
//
//    @Autowired
//    private IDroneService _droneservice;
//
//    public DispatchController( IDroneService droneservice) {
//        _droneservice = droneservice;
//    }
//    @PostMapping("/RegisterDrones")
//    public ResponseEntity<Drones> RegisterDrone (@RequestBody Drones drones) {
//
//        try {
//            return new ResponseEntity<Drones>(_droneservice.SaveDrone(drones),HttpStatus.CREATED);
//        }
//        catch (Exception e){
//
//           return new ResponseEntity<Drones>((Drones) null,HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//    }
//
//    @PostMapping("/LoadDroneWithMedication")
//    public    ResponseEntity<Drones> LoadDroneWithMedication (@RequestBody MedicationLoaderWrapper loadMedicine) {
//
//        try {
//            return new ResponseEntity<Drones>(_droneservice.LoadMedicationToDrone(loadMedicine),HttpStatus.CREATED);
//        }
//        catch (Exception e){
//            return new ResponseEntity<Drones>((Drones) null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//
//
//
//
//
//
//
//    @PostMapping("/LoadDroneWithMedications")
//    public    ResponseEntity<Drones> LoadDroneWithMedications (@RequestBody LoadingBayVM loadMedicine) {
//
//        //  LoadingBayVM car = objectMapper.readValue(json, Car.class);
//
//
//        try {
//            LoadingBayVM _data = new com.fasterxml.jackson.databind.ObjectMapper().readValue(loadMedicine.toString(), LoadingBayVM.class);
//
//            System.out.println(_data);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//
////        try {
////            return new ResponseEntity<Drones>(_droneservice.LoadMedicationToDrone(loadMedicine),HttpStatus.CREATED);
////        }
////        catch (Exception e){
////
////        }
//        return new ResponseEntity<Drones>((Drones) null,HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
//
//
//
//
//
//
//    @GetMapping(path = "/getAllDrones")
//    public List<Drones> getAllDrones() {
//        return _droneservice.getAvailableDrones();
//    }
//
//
//}
//
//
