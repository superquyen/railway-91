package com.vti.backend;

import com.vti.entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class BaiTap {
     public static ArrayList<Student> studentArrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void ThemSv(){
        System.out.println("Thêm mới sinh viên");
        System.out.println("Thêm ID của sinh viên mới");
        int addId = sc.nextInt();
        Student student = new Student();
        student.setId(addId);
        System.out.println("Thêm tên của sinh viên mới");
        sc.nextLine();
        String addName = sc.nextLine();
        student.setName(addName);
        studentArrayList.add(student);
        System.out.println("Đã thêm mới sinh viên thành công");
    }
    public void InSv(){
        System.out.println("In danh sách sinh viên ");
        for(Student student: studentArrayList){
            System.out.println(student.toString());
        }
    }
    public void TimSv(){
        System.out.println("Tìm kiếm sinh viên theo tên");
        System.out.println("Nhập tên sinh viên bạn muốn tìm");
        String timten = sc.nextLine().toLowerCase();
        for (Student student : studentArrayList){
            if(student.getName().toLowerCase().contains(timten)){
                System.out.println(student.toString());
            }
        }

    }
}
