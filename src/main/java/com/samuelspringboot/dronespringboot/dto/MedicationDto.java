package com.samuelspringboot.dronespringboot.dto;

import javax.validation.constraints.Pattern;

public class MedicationDto {


    @Pattern(regexp ="[a-zA-Z_0-9-]",message = "only letters ,_,- allowed")
    private String name;
    private Long weight;
    @Pattern(regexp = "[A-Z_0-9]",
    message = "Only uppercase letters numbers and underscore is allowed")
    private String code;
    private  String image;

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
        return "MedicationDto{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
