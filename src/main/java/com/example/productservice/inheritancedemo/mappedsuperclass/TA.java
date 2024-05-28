package com.example.productservice.inheritancedemo.mappedsuperclass;

import com.example.productservice.inheritancedemo.mappedsuperclass.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

@Getter
@Setter
@Entity(name = "mp_ta")
public class TA extends User {
    private int numberOfSession;
    private double avgrating;
}
