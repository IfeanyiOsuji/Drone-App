package com.musalasoft.droneservice;

import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.Model;
import com.musalasoft.droneservice.Repo.DroneRepo;
import com.musalasoft.droneservice.Service.DroneService;
import com.musalasoft.droneservice.Service.DroneServiceImpl2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@EnableScheduling
public class DroneserviceApplication {
@Autowired
 DroneService droneService;
	public static void main(String[] args) {

		SpringApplication.run(DroneserviceApplication.class, args);

	}
	@Bean
	public CommandLineRunner CommandLineRunner(){
		Drone drone1  = new Drone(200, Model.Lightweight);
			drone1.setBatteryCapacity(200);
			Drone drone2 = new Drone(230, Model.Cruiseweight);
			drone2.setBatteryCapacity(230);

			droneService.registerDrone(drone1);
		droneService.registerDrone(drone2);
		return args ->{
			
		List<Drone>drones = droneService.getAllDrones();
		System.out.println(drones.toString());
		//drones.forEach((drone) -> droneService.setDroneBatteryLimit(drone));
		

		};
	}


}
