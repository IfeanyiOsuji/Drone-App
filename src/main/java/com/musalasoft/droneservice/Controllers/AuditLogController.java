package com.musalasoft.droneservice.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musalasoft.droneservice.Models.AuditLog;
import com.musalasoft.droneservice.Repo.AuditLogRepo;
import com.musalasoft.droneservice.Service.AuditLogService;

@RestController
@RequestMapping("api/v1/droneservice/eventlog/")
public class AuditLogController {

    @Autowired
AuditLogService auditLogService;
@Autowired
AuditLogRepo logRepo;

@GetMapping("/getlogforday/{date}")
public ResponseEntity<List<AuditLog>> getLogHistoryForDay(@PathVariable String date){

    return new ResponseEntity<List<AuditLog>>(auditLogService.getLogsforDay(date), null, HttpStatus.OK);
}

@GetMapping("/getlogbetweendates/{startDate}&&{endDate}")
public ResponseEntity<List<AuditLog>>getLogBetweenDates(@PathVariable String startDate, @PathVariable String endDate){

    return new ResponseEntity<List<AuditLog>>(auditLogService.getLogBetweenDates(startDate, endDate), null, HttpStatus.OK);
}

@GetMapping("/getlogHistory")
public ResponseEntity<List<AuditLog>>getLogHistory(){
    return new ResponseEntity<List<AuditLog>>(logRepo.findAll(), null, HttpStatus.OK);
}
    
}
