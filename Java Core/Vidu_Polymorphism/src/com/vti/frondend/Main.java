package com.vti.frondend;

import com.vti.entity.IStudent;
import com.vti.entity.Student;

public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[10];

        for(int i=0; i < students.length; i++){
            Student student = new Student();
            student.setId(i);
            student.setName("Nguyễn văn " + i);
            if(i <= 3){
                student.setGroup(1);
            }else if(i>3 && i <=7){
                student.setGroup(2);
            }else{
                student.setGroup(3);
            }
            students[i] = student;
        }
        for(Student student: students ){
            student.diemDanh();

        }
        for(Student student : students){
            if(student.getGroup() == 1){
                student.hocBai();
            }
        }
        for (Student student : students){
            if(student.getGroup() == 2){
                student.diDonVeSinh();
            }
        }





    }

}
