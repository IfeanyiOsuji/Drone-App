package com.musalasoft.droneservice.dtos;

import com.musalasoft.droneservice.Models.Medication2;
import com.musalasoft.droneservice.Models.Model;
import com.musalasoft.droneservice.Models.State;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class DroneRespnse {
    private Long serialNumber;

    private int weight;

    private String batteryCapacity;


    private State state;

    private Model model;
    private List<Medication2> medications = new ArrayList<>();

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<Medication2> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication2> medications) {
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "DroneRespnse{" +
                "serialNumber=" + serialNumber +
                ", weight=" + weight +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                ", state=" + state +
                ", model=" + model +
                ", medications=" + medications +
                '}';
    }
}
