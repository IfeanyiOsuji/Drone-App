package com.musalasoft.droneservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.musalasoft.droneservice.Models.Drone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportDroneBatteryCapacity(Drone drone) {
        log.info("Drone with serial number {} has a battery capacity of {} as at {}",drone.getSerialNumber(),drone.getBatteryCapacity(), dateFormat.format(new Date()));
    }
}
