package com.musalasoft.droneservice.Models;

import com.musalasoft.droneservice.utils.ScheduledTasks;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.naming.LimitExceededException;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "drones")
public class Drone {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_number", length = 100)
    private String serialNumber;


    private int weight;
    @Column(nullable = false)
    private String batteryCapacity;

    

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    // This is a default state of the drone
    private State state;
    
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Model model;

    @OneToMany
    private List<Medication2> medications = new ArrayList<>();

    public Drone(int weight,Model model) {
        this.serialNumber = UUID.randomUUID().toString().substring(25);
        this.weight = weight;
        this.state = State.IDLE;
        this.model = model;

    }
    protected Drone (){
        this.serialNumber = UUID.randomUUID().toString().substring(25);
        this.state = State.IDLE;
    }

    public void setBatteryCapacity(int batteryCapacity){
        this.batteryCapacity =Integer.toString(batteryCapacity) +"%";
    }
    public void setSerialNumber(String serialNumber) throws LimitExceededException {
        if(serialNumber.length() > 100)
            throw new LimitExceededException("length exceeded");
        this.serialNumber = serialNumber;

    }
    public void setState(State state){

        this.state = state;
    }
    public State getState(){
        return this.state;
    }
    public int getWeight(){
        return this.weight;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public List<Medication2> getMedications() {
        return medications;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public Model getModel(){
        return this.model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Drone{" +
                "serialNumber=" + serialNumber +
                ", weight=" + weight +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                ", state=" + state +
                ", model=" + model +
                '}';
    }
}
