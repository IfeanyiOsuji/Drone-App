package com.musalasoft.droneservice.Models;

import javax.naming.NamingException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medication2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private int weight;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NamingException {
        if(!name.matches("[a-zA-Z0-9_-]*$"))
            throw new NamingException("Name can only contain alphabets, numbers, _ and -");
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) throws NamingException {
        if(!code.matches("[A-Z0-9_-]*"))
            throw new NamingException("Code can only contain Upercase letters, Numbers, _ and -");
        this.code = code;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Medication2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", weight=" + weight +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
