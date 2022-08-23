//package com.musalasoft.droneservice.Models;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name = "tbl_LoadingBay")
//public class LoadingBay {
//
//    @Id
//    @Column(name = "LoadingID")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer LoadingID;
//    //Serial Number of the Drone that is Loaded
//    @Column(name = "Serial_Number", length = 100)
//    private Integer Serial_Number;
//    @Column(name = "State")
//    private String State;
//    public LoadingBay(){
//        super();
//    }
//
//    public Integer getLoadingID() {
//        return LoadingID;
//    }
//
//    public void setLoadingID(Integer loadingID) {
//        LoadingID = loadingID;
//    }
//
//    @Override
//    public String toString() {
//        return "LoadingBay{" +
//                "LoadingID=" + LoadingID +
//                ", Serial_Number=" + Serial_Number +
//                ", State='" + State + '\'' +
//                '}';
//    }
//
//    public Integer getSerial_Number() {
//        return Serial_Number;
//    }
//
//    public void setSerial_Number(Integer serial_Number) {
//        Serial_Number = serial_Number;
//    }
//
//    public String getState() {
//        return State;
//    }
//
//    public void setState(String state) {
//        State = state;
//    }
//
//    public LoadingBay(Integer loadingID, Integer serial_Number, String state) {
//        LoadingID = loadingID;
//        Serial_Number = serial_Number;
//        State = state;
//    }
//}
//
//
//
