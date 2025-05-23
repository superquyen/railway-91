package com.data.controller;

import com.data.dto.CourseDTO;
import com.data.dto.LessonCourseDTO;
import com.data.dto.LessonDTO;
import com.data.entity.Courses;
import com.data.entity.Lesson;
import com.data.repository.CoursesRepository;
import com.data.req.CoursesCreateReq;
import com.data.req.CoursesUpdateReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("courses")
@Validated
public class CoursesController {
    private final CoursesRepository coursesRepository;
    @Autowired
    public CoursesController(CoursesRepository coursesRepository){
        this.coursesRepository = coursesRepository;
    }
    @GetMapping
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<Courses> courses = coursesRepository.findAll(pageable);
        List<CourseDTO>courseDTOS = new ArrayList<>();
        courses.forEach(obj ->{
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(obj.getId());
            courseDTO.setCourseName(obj.getCourseName());
            courseDTO.setSoGio(obj.getSoGio());
            courseDTO.setSoBuoi(obj.getSoBuoi());
            List<Lesson> lessons = obj.getLessons() != null ? obj.getLessons() : new ArrayList<>();
            List<LessonCourseDTO>lessonCourseDTOS = new ArrayList<>();
            lessons.forEach(obj2->{
                LessonCourseDTO lessonCourseDTO = new LessonCourseDTO();
                lessonCourseDTO.setId(obj2.getId());
                lessonCourseDTO.setLessonName(obj2.getLessonName());
                lessonCourseDTO.setMoTa(obj2.getMoTa());
                lessonCourseDTO.setSoGio(obj2.getSoGio());
                lessonCourseDTOS.add(lessonCourseDTO);
            });
            courseDTO.setLessons(lessonCourseDTOS);
            courseDTOS.add(courseDTO);
        });
        return ResponseEntity.ok(courseDTOS);
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CoursesCreateReq coursesCreateReq){
        Optional<Courses> coursesOptional = coursesRepository.findCourseByCourseName(coursesCreateReq.getCourseName());
        if(coursesOptional.isPresent()){
            return ResponseEntity.badRequest().body("da ton tai khoa hoc nay roi");
        }
        Courses courses = new Courses();
        courses.setCourseName(coursesCreateReq.getCourseName());
        courses.setSoBuoi(coursesCreateReq.getSoBuoi());
        courses.setSoGio(coursesCreateReq.getSoGio());
        coursesRepository.save(courses);
        return ResponseEntity.ok("them moi course thanh cong");
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@Valid @PathVariable int id,
                                          @RequestBody CoursesUpdateReq coursesUpdateReq){
       Courses courses = coursesRepository.findById(id).orElse(null);
        if(courses == null) {
            return ResponseEntity.badRequest().body("khong ton tai course nay");

        }
        courses.setCourseName(coursesUpdateReq.getCourseName());
        courses.setSoBuoi(coursesUpdateReq.getSoBuoi());
        courses.setSoGio(coursesUpdateReq.getSoGio());
        coursesRepository.save(courses);
        return ResponseEntity.ok("Update thanh cong");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        Optional<Courses>courses = coursesRepository.findById(id);
        if(courses.isPresent()){
            coursesRepository.deleteById(id);
            return ResponseEntity.ok("Da xoa xong course");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Khong tim thay course co id nay: "+id);

    }
}
