package com.musalasoft.droneservice.Repo;

import com.musalasoft.droneservice.Models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepo extends JpaRepository<Drone, String> {

}
