package com.musalasoft.droneservice.Models;
import java.util.Arrays;

public class Medication {

    private String Code;
    private String name;
    private String Model;
    private double Weight;
    private byte[] Image;


    public Medication(String name,
                      String model,
                      double weight,
                      byte[] image) {
        this.name = name;
        Model = model;
        Weight = weight;
        Image = image;
    }

    public Medication(String code,
                      String name,
                      String model,
                      double weight,
                      byte[] image)
    {
        Code = code;
        this.name = name;
        Model = model;
        Weight = weight;
        Image = image;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }


    @Override
    public String toString() {
        return "Medication{" +
                "Code='" + Code + '\'' +
                ", name='" + name + '\'' +
                ", Model='" + Model + '\'' +
                ", Weight=" + Weight +
                ", Image=" + Arrays.toString(Image) +
                '}';
    }
}
