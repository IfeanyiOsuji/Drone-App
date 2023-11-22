package com.musalasoft.droneservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.musalasoft.droneservice.Models.AuditLog;
import com.musalasoft.droneservice.Models.Drone;
import com.musalasoft.droneservice.Models.State;

import com.musalasoft.droneservice.Service.AuditLogService;
import com.musalasoft.droneservice.Service.DroneService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    @Autowired
DroneService droneService;

@Autowired
AuditLogService auditLogService;

private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    
    @Scheduled(cron = "0 */1 * ? * *")
    public void setDroneBatteryLimit() {
        Iterable<Drone>drones = droneService.getAllDrones();
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
                 droneService.registerDrone(drone);
                 AuditLog auditLog = new AuditLog();
                 auditLog.setEventDate(new Date());
                 auditLog.setLevel("info");
                 auditLog.setMessage(String.format("Drone with serial number %s has a battery capacity of %s as at %s",drone.getSerialNumber(),drone.getBatteryCapacity(), dateFormat.format(new Date())));
                 auditLog.setDroneSerialNumber(drone.getSerialNumber());
                 auditLog.setDroneBatteryCapacity(drone.getBatteryCapacity());

                    auditLogService.registerLog(auditLog);
                log.info("Drone with serial number {} has a battery capacity of {} as at {}",drone.getSerialNumber(),drone.getBatteryCapacity(), dateFormat.format(new Date()));
        
        }

    }
}
