package com.catalogmanagementsystem.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long userId;

    @NotEmpty
    private String username;

    @Email
    private String email;

    @NotEmpty
    private String password;


    private Date registrationDate;

    @NotEmpty
    private String name;


    private String address;
}
