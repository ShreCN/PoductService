package com.example.productservice.inheritancedemo.tableperclass;
import com.example.productservice.inheritancedemo.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "tpc_instructor")
public class Instructor extends User {
    private String specialisation;
}
