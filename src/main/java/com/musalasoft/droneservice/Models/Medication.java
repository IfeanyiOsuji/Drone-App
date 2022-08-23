//package com.musalasoft.droneservice.Models;
//import javax.persistence.Id;
//import java.util.Arrays;
//import java.util.regex.Pattern;
//
//public class Medication {
//
//
//    @Id
//    private String Code;
//    private String name;
//    private String Model;
//    private double Weight;
//    private byte[] Image;
//
//
//    public Medication(String name,
//                      String model,
//                      double weight,
//                      byte[] image) {
//        this.name = name;
//        Model = model;
//        Weight = weight;
//        Image = image;
//    }
//
//    public Medication(String code,
//                      String name,
//                      String model,
//                      double weight,
//                      byte[] image)
//    {
//      this.Code = code;
//        this.name = name;
//        this.Model = model;
//        this.Weight = weight;
//        Image = image;
//    }
//
//    public String getCode() {
//        return Code;
//    }
//
//    public void setCode(String code) {
//
//
//        if(!Pattern.matches("^[A-Z0-9_]*$", code)) {
//
//            throw new IllegalArgumentException("The Medication allows only upper case letters, underscore and numbers. Please review and try again. Thank you.");
//        }
//        Code = code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//
//
//        if(!Pattern.matches("^[a-zA-Z0-9_-]*$", name)) {
//
//            throw new IllegalArgumentException("The Medication allows only letters, numbers, ‘-‘ and ‘_’. Please review and try again. Thank you.");
//
//        }
//
//        this.name = name;
//    }
//
//    public String getModel() {
//        return Model;
//    }
//
//    public void setModel(String model) {
//        Model = model;
//    }
//
//    public double getWeight() {
//        return Weight;
//    }
//
//    public void setWeight(double weight) {
//        Weight = weight;
//    }
//
//    public byte[] getImage() {
//        return Image;
//    }
//
//    public void setImage(byte[] image) {
//        Image = image;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Medication{" +
//                "Code='" + Code + '\'' +
//                ", name='" + name + '\'' +
//                ", Model='" + Model + '\'' +
//                ", Weight=" + Weight +
//                ", Image=" + Arrays.toString(Image) +
//                '}';
//    }
//}
