package com.data.repository;

import com.data.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    Optional<Courses> findCourseByCourseName(String courseName);
}
