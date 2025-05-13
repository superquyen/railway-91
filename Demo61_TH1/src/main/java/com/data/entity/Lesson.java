package com.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lessonName;
    private int soGio;
    private String moTa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "course_id")
    private Courses courses;
}
