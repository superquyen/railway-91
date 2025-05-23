package com.data.entity;

import com.data.req.CoursesCreateReq;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table
@ToString
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lessonName;
    private int soGio;
    private String moTa;

    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    @JoinColumn(name= "course_id")
    private Courses courses;
}
