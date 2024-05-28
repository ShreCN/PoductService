package com.example.productservice.inheritancedemo.mappedsuperclass;
import com.example.productservice.inheritancedemo.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "mp_instructor")
public class Instructor extends User {
    private String specialisation;
}
