package com.musalasoft.droneservice.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.State;
import com.musalasoft.droneservice.Repo.DroneRepo;
import com.musalasoft.droneservice.utils.ScheduledTasks;

@Service
public class DroneServiceBatteryImpl implements DroneBatteryService{
    @Autowired
DroneRepo droneRepo;

private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    @Scheduled(fixedRate = 5000000)
    public void setDroneBatteryLimit() {
        Iterable<Drone>drones = droneRepo.findAll();
        for(Drone drone : drones){
            int batteryLevel = Integer.parseInt(drone.getBatteryCapacity().substring(0, drone.getBatteryCapacity().length()-1));
             if (drone.getState().equals(State.IDLE)) {
                    
                     drone.setBatteryCapacity(batteryLevel - 1);
                 }
                 if (drone.getState().equals(State.LOADING)) {
                     
                     drone.setBatteryCapacity(batteryLevel - 3);
                 }
                 if (drone.getState().equals(State.LOADED)) {
                     
                     drone.setBatteryCapacity(batteryLevel - 4);
                 }
                 droneRepo.save(drone);
                log.info("Drone with serial number {} has a battery capacity of {} as at {}",drone.getSerialNumber(),drone.getBatteryCapacity(), dateFormat.format(new Date()));
        
        }

    }
    
}
