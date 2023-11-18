package com.musalasoft.droneservice;

import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.Medication2;
import com.musalasoft.droneservice.Models.Model;
import com.musalasoft.droneservice.Repo.DroneRepo;
import com.musalasoft.droneservice.Service.DroneService;
import com.musalasoft.droneservice.Service.MedicationService;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.LimitExceededException;
import javax.naming.NamingException;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@Slf4j
@SpringBootTest
class DroneserviceApplicationTests {
//	private DataSource dataSource;
	@Autowired
   private DroneRepo droneRepo;
	@Autowired
   private DroneService droneService;

	@Autowired
	private MedicationService medicationService;
	@Test
	void contextLoads() {
	}

//	@Test
//	public void testDbConnection(){
//		try {
//			Connection connection = dataSource.getConnection();
//			Assertions.assertThat(connection).isNotNull();
//		}
//		catch (SQLException exception){
//			log.info("An exception occured -> {}", exception.getMessage());
//		}
//	}
	// @Test
	// public void testThatDroneIsRegistered(){
	// 	Drone droneToRegister = new Drone(50, Model.Lightweight);
	// 	droneToRegister.setBatteryCapacity(290);
	// 	droneService.registerDrone(droneToRegister);
	// 	Drone drone = droneService.findDroneBySerialNumber(1l);
	// 	assertThat(drone.getModel()).isNotNull();
	// 	log.info("Drone -> {}", drone);
	// }

	// @Test
	// @Transactional
	// @Rollback(value = false)
	// public void test_that_drones_can_be_loaded_with_medications(){
	// 		Drone drone = new Drone(50, Model.Lightweight);

	// 		drone.setBatteryCapacity(230);
	// 		Drone savedDrone = droneService.registerDrone(drone);
	// 		log.info("saved Drone -> {}", savedDrone);
	// 		assertThat(savedDrone.getWeight()).isNotNull();


	// 	Medication2 medication2 = new Medication2();
	// 	Medication2 medication21 = new Medication2();
	// 	Medication2 medication22 = new Medication2();
	// 	try {
	// 		medication2.setName("Panadol");
	// 		medication2.setCode("PAN222");
	// 		medication2.setWeight(55);

	// 		medication21.setName("Paracetamol");
	// 		medication21.setCode("PAR122");
	// 		medication21.setWeight(54);

	// 		medication22.setName("Ampeciline");
	// 		medication22.setCode("AMP214");
	// 		medication22.setWeight(35);

	// 		medicationService.saveAllMedications(List.of(medication21,medication2,medication22));


	// 		droneService.loadDroneWithMedicationItems(1l, List.of(medication21, medication2, medication22) );
	// 		Drone drone2 = droneService.findDroneBySerialNumber(1l);
	// 		log.info("List of Medications for droneId {} ->{}", drone2.getSerialNumber(), drone2.getMedications());
	// 		assertThat(drone2.getMedications().size()).isEqualTo(3);
	// 		log.info("Saved drone -> {} and state ->{}", drone2, drone2.getState());

	// 	} catch (NamingException e) {
	// 		e.printStackTrace();
	// 	}
	// }

}
