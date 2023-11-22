package com.musalasoft.droneservice.Models;

import javax.persistence.Column;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;


@Entity
@Data
public class AuditLog {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String level;

    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private Date eventDate;

    private String droneSerialNumber;
    private String droneBatteryCapacity;
   
    
}
