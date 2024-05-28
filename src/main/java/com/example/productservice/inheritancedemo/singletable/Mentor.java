package com.example.productservice.inheritancedemo.singletable;


import com.example.productservice.inheritancedemo.mappedsuperclass.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sc_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private String compName;
    private double avgrating;
}
