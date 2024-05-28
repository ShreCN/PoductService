package com.example.productservice.inheritancedemo.mappedsuperclass;


import com.example.productservice.inheritancedemo.mappedsuperclass.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

@Getter
@Setter
@Entity(name = "mp_mentor")
public class Mentor extends User {
    private String compName;
    private double avgrating;
}
