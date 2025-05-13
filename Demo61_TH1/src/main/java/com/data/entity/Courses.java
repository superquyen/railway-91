package com.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int soBuoi;
    private int soGio;
    @OneToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Lesson>lessons;
}
