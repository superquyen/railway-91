package com.data.controller;


import com.data.dto.LessonDTO;
import com.data.entity.Courses;
import com.data.entity.Lesson;
import com.data.repository.CoursesRepository;
import com.data.repository.LessonRepository;
import com.data.req.LessonCreateReq;
import com.data.req.LessonUpdateReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("lessons")
@Validated
public class LessonController {
    private final LessonRepository lessonRepository;
    public LessonController(LessonRepository lessonRepository){

        this.lessonRepository = lessonRepository;
    }
    @Autowired
    private CoursesRepository coursesRepository;
    @GetMapping
    public ResponseEntity<?> getAllLessons(Pageable pageable){
        Page<Lesson>lessons = lessonRepository.findAll(pageable);
        List<LessonDTO>lessonDTOS = new ArrayList<>();
        lessons.forEach(obj1->{
            LessonDTO lessonDTO = new LessonDTO();
            lessonDTO.setId(obj1.getId());
            lessonDTO.setLessonName(obj1.getLessonName());
            lessonDTO.setSoGio(obj1.getSoGio());
            lessonDTO.setMoTa(obj1.getMoTa());
            lessonDTO.setCourseId(obj1.getCourses().getId());
            lessonDTO.setCourseName(obj1.getCourses().getCourseName());
            lessonDTOS.add(lessonDTO);
        });
        return ResponseEntity.ok(lessonDTOS);
    }
    @PostMapping
    public ResponseEntity<?>addNewLesson(@Valid @RequestBody LessonCreateReq lessonCreateReq){
        Optional<Lesson> lessons = lessonRepository.findByLessonName(lessonCreateReq.getLessonName());
        if(lessons.isPresent()){
            return ResponseEntity.badRequest().body("da ton tai lesson nay");
        }
        Optional<Courses> coursesOptional = coursesRepository.findById(lessonCreateReq.getCourseId());
        if(coursesOptional.isEmpty()) {
           return ResponseEntity.badRequest().body("ban chua gan dung lesson vao khoa hoc");
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonCreateReq.getLessonName());
        lesson.setSoGio(lessonCreateReq.getSoGio());
        lesson.setMoTa(lessonCreateReq.getMoTa());
        lesson.setCourses(coursesOptional.get());
        lessonRepository.save(lesson);
        return ResponseEntity.ok("ban da cap nhat moi thanh cong");
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateLesson(@PathVariable int id,
                                          @RequestBody LessonUpdateReq lessonUpdateReq){
        Lesson lesson = lessonRepository.findById(id).orElse(null);
        if(lesson == null){
            return ResponseEntity.badRequest().body("Khong ton tai mon co id la: "+id);
        }
        Optional<Courses>coursesOptional = coursesRepository.findById(lessonUpdateReq.getId());
        if(coursesOptional.isEmpty()) {
           return ResponseEntity.badRequest().body("khong ton tai course ung voi lesson nay");
        }
        lesson.setLessonName(lessonUpdateReq.getLessonName());
        lesson.setSoGio(lessonUpdateReq.getSoGio());
        lesson.setMoTa(lessonUpdateReq.getMoTa());
        lesson.setCourses(coursesOptional.get());
        lessonRepository.save(lesson);
        return ResponseEntity.ok("Ban vua cap nhat thanh cong mon hoc moi");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?>deleteLesson(@PathVariable int id){
        Lesson lesson = lessonRepository.findById(id).orElse(null);
        if(lesson == null){
            return ResponseEntity.badRequest().body("Khong ton tai mon hoc co id la: "+id);
        }
        lessonRepository.delete(lesson);
        return ResponseEntity.ok("Ban vua xoa thanh cong mon hoc co id la: "+ id);
    }
}
