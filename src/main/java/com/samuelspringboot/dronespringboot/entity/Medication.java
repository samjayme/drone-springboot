package com.samuelspringboot.dronespringboot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Entity
public class Medication {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    //@Pattern(regexp = "[a-zA-Z0-9](?=.*[-_])",
           // message = "name must contain at least 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String name;
    private Long weight;
    //@Pattern(regexp ="(?=.*[A-Z](?=.*[0-9]) (?=.*[-_] ))",  //"[A-Z0-9_.]*",
           // message = "only uppercase letters,underscore and number is allowed".
    private String code;
    private  String image;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;


    }

    @Override
    public String toString() {
        return "Medication{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}