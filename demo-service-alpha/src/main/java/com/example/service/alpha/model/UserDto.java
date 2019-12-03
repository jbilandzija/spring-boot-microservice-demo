package com.example.service.alpha.model;

import lombok.Data;

@Data
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private long salary;
}
