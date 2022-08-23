//package com.musalasoft.droneservice.Models;
//
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//
//import java.util.List;
//
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
//public class MedicationLoaderWrapper {
//
//    private Integer Serial_Number;
//    private String State;
//    private List<Med> Medications;
//
//    public MedicationLoaderWrapper(Integer serial_Number, String state, List<Med> medications) {
//        Serial_Number = serial_Number;
//        State = state;
//        Medications = medications;
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
//    public List<Med> getMedications() {
//        return Medications;
//    }
//
//    public void setMedications(List<Med> medications) {
//        Medications = medications;
//    }
//
//
//    @Override
//    public String toString() {
//        return "MedicationLoaderWrapper{" +
//                "Serial_Number=" + Serial_Number +
//                ", State='" + State + '\'' +
//                ", Medications=" + Medications +
//                '}';
//    }
//}