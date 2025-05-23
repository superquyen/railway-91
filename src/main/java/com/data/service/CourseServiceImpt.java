package com.data.service;

import com.data.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpt implements CourseService{
    @Autowired
    private CoursesRepository coursesRepository;

}
