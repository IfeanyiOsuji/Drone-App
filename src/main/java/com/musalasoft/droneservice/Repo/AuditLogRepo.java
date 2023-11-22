package com.musalasoft.droneservice.Repo;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.musalasoft.droneservice.Models.AuditLog;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long>{

    // @Query("SELECT i from AuditLog i WHERE CAST(DATE_TRUNC('DAY', i.eventDate) as DATE) = :date")
    // public List<AuditLog> findTimestampByDate(@Param("date") Date date);

    @Query("SELECT i from AuditLog i WHERE i.eventDate BETWEEN :startDate AND :endDate")
    public List<AuditLog>findTimestampBetweenDates(@Param("startDate") LocalDate starDate, @Param("endDate")LocalDate enDate);

     @Query("Select i FROM AuditLog i")
    public List<AuditLog> findTimestampByDate1();
    
}
