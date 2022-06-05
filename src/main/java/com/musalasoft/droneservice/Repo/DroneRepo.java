package com.musalasoft.droneservice.Repo;

import com.musalasoft.droneservice.Models.Drones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DroneRepo extends CrudRepository<Drones,Integer>
{

}
