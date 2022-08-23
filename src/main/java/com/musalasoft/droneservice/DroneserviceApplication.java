package com.musalasoft.droneservice;

import com.musalasoft.droneservice.Service.DroneServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DroneserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneserviceApplication.class, args);

		DroneServiceImpl2 droneServiceImpl2 = new DroneServiceImpl2();
		droneServiceImpl2.
	}


}
