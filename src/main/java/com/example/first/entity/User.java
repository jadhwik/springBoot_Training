package com.example.first.entity;


import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {

    @Id
    @Generated

    private int id;
    private String name;
    private int age;


}
