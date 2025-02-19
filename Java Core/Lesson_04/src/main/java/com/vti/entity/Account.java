package com.vti.entity;

import java.time.LocalDate;
import java.util.Date;

import static java.time.LocalDate.now;

public class Account {
    public int id;
   public String email;
    public String username;
    public String fisrtname;
    public String lastname;
    public String fullname;
    public String position;
    public LocalDate createdate;
    public Date create;
    public Account (){


    }
    public Account(int id, String username, String fisrtname, String lastname, String fullname){
        this.id = id;
        this.username = username;
        this.fullname = fisrtname + lastname;
    }
    public Account(int id, String username, String fisrtname, String lastname, String position, LocalDate createdate){
        this.id = id;
        this.username = username;
        this.fullname = fisrtname + lastname;
        this.position = position;
        this.createdate = now();
        this.create = new Date();
    }
}
