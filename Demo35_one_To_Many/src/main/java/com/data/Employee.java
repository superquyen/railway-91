package com.data;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "employee_name")
    private String employeeName;
    private String phone;
    // nhiều Employee thuộcc 1 department: @ManyToOne
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee(){

    }
    public Employee(int id, String employeeName, String phone, Department department) {
        this.id = id;
        this.employeeName = employeeName;
        this.phone = phone;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", phone='" + phone + '\'' +
                ", department_id=" + department +
                '}';
    }
}
