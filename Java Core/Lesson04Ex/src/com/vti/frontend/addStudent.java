package com.vti.frontend;

import java.util.ArrayList;
import java.util.Scanner;

public class addStudent {
    private ArrayList<Student> studentsList = new ArrayList<>();
public void AddStudent1(){
    Student st1 = new Student();
    st1.setName("Nguyen Van A");
    st1.setScore(8.5);
    Student st2 = new Student();
    st2.setName("Tran Thi B");
    st2.setScore(7.8);
    Student st3 = new Student();
    st3.setName("Tran Thi B");
    st3.setScore(6.9);
    Student st4 = new Student();
    st4.setName("Nguyen Thi D");
    st4.setScore(9.0);

    studentsList.add(st1);
    studentsList.add(st2);
    studentsList.add(st3);
    studentsList.add(st4);


    }
    public void AddStudent2(){
    Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên cần tìm: ");
    String nhapTen = sc.nextLine().toLowerCase();
    boolean found = false;
        System.out.println("Danh sách sinh viên có tên chứa " +nhapTen + ":");
        int intdex = 1;
    for(Student student : studentsList){

        if(student.getName().toLowerCase().contains(nhapTen)){

            System.out.println(intdex+"." + student.toString());
            found = true;
        }
        intdex++;

    }
    if(!found){
        System.out.println("Không tìm thấy sinh viên nào.");
        System.out.println(studentsList.toString());
    }
}
}
