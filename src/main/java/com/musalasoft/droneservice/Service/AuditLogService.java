package com.musalasoft.droneservice.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.musalasoft.droneservice.Models.AuditLog;

@Service
public interface AuditLogService {

    public AuditLog registerLog(AuditLog log);

    public List<AuditLog> getLogsforDay(String date);
    public List<AuditLog> getLogBetweenDates(String startDate, String endDate);
    
}
