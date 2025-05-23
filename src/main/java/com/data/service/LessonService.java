package com.data.service;


import com.data.entity.Lesson;
import com.data.repository.LessonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public Page<Lesson> findAll(Pageable pageable) {
       return lessonRepository.findAll(pageable);
    }
}
