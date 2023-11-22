package com.musalasoft.droneservice.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musalasoft.droneservice.Models.AuditLog;
import com.musalasoft.droneservice.Repo.AuditLogRepo;


@Service
public class AuditLogServiceImpl implements AuditLogService{
    
    @Autowired
    AuditLogRepo logRepo;

    @Override
    public List<AuditLog> getLogsforDay(String date)  {
        LocalDate date2 = convertStringToDate(date);
        System.out.println("Date1 "+date2.toString());
        List<AuditLog> logs = logRepo.findTimestampByDate1().stream().filter(log -> log.getEventDate().toString().startsWith(date2.toString().substring(0,10))).toList();
        return logs;
        
    }

    @Override
    public List<AuditLog> getLogBetweenDates(String startDate, String endDate) {
       LocalDate startDate1 = convertStringToDate(startDate);
       LocalDate endDate1 = convertStringToDate(endDate);
        
       return logRepo.findTimestampBetweenDates(startDate1, endDate1);
       
    }

    private LocalDate convertStringToDate(String startDate) {
        String formatPattern = "yyyy-MM-dd"; // Date format of your string
        LocalDate date = null;
        try{
            DateTimeFormatter datefFormatter = DateTimeFormatter.ofPattern(formatPattern);
            date = LocalDate.parse(startDate, datefFormatter);
        }
        catch(Exception ex){
            System.out.println("Error occurred while parsing date: " + ex.getMessage());
        }
        return date;
    }

    @Override
    public AuditLog registerLog(AuditLog log) {
        // TODO Auto-generated method stub
        return logRepo.save(log);
    }
}
