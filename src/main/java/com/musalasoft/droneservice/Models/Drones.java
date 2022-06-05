package com.musalasoft.droneservice.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


    @Entity
    @Table(name = "tbl_Drones")
    public class Drones {

        @Id
        @Column(name = "Serial_Number" )
        private String Serial_Number;

        @Column(name = "Model")
        private String Model;

        @Column(name = "Weight_Limit")
        private double Weight_Limit;

        @Column(name = "Battery_Capacity")
        private Integer Battery_Capacity;

        @Column(name = "State")
        private String State;


        public Drones(){
            super();
        }

        public Drones(String serial_Number,
                      String model,
                      double weight_Limit,
                      Integer battery_Capacity,
                      String state) {
            Serial_Number = serial_Number;
            Model = model;
            Weight_Limit = weight_Limit;
            Battery_Capacity = battery_Capacity;
            State = state;
        }


        public Drones(String model,
                      Integer weight_Limit,
                      Integer battery_Capacity,
                      String state)
        {
            Model = model;
            Weight_Limit = weight_Limit;
            Battery_Capacity = battery_Capacity;
            State = state;
        }

        public String getSerial_Number() {
            return Serial_Number;
        }

        public void setSerial_Number(String serial_Number) {
            Serial_Number = serial_Number;
        }

        public String getModel() {
            return Model;
        }

        public void setModel(String model) {
            Model = model;
        }

        public double getWeight_Limit() {
            return Weight_Limit;
        }

        public void setWeight_Limit(Integer weight_Limit) {
            Weight_Limit = weight_Limit;
        }

        public Integer getBattery_Capacity() {
            return Battery_Capacity;
        }

        public void setBattery_Capacity(Integer battery_Capacity) {
            Battery_Capacity = battery_Capacity;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        @Override
        public String toString() {
            return "Drones{" +
                    "Serial_Number='" + Serial_Number + '\'' +
                    ", Model='" + Model + '\'' +
                    ", Weight_Limit=" + Weight_Limit +
                    ", Battery_Capacity=" + Battery_Capacity +
                    ", State='" + State + '\'' +
                    '}';
        }
    }

