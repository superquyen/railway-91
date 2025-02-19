package com.vti.frontend;

import com.vti.entity.Account;
import com.vti.entity.Department;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.id = 2;
        department1.name= "Haha";
        Department department2 = new Department(12, "SPQ");
        System.out.println(department2.id +   department2.name);
        System.out.println(department1.id + department1.name);
        Account acc1 = new Account(10, "SPQ", "VO", "Quyen","Chu tich", LocalDate.now());
        System.out.println(acc1.fullname);
        System.out.println(acc1.createdate);
        System.out.println(acc1.create);
    }

}
