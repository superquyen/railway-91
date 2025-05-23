package com.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@Table
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private LocalDate createDate;
    private LocalDate updateDate;
    private LocalDate birthDay;
    private String address;
    private String role;
}
