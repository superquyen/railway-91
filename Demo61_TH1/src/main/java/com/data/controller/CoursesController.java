package com.data.controller;

import com.data.dto.CourseDTO;
import com.data.dto.LessonDTO;
import com.data.entity.Courses;
import com.data.entity.Lesson;
import com.data.repository.CoursesRepository;
import com.data.req.CoursesCreateReq;
import com.data.req.CoursesUpdateReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("courses")
public class CoursesController {
    private CoursesRepository coursesRepository;
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
            List<Lesson> lessons = obj.getLessons();
            List<LessonDTO>lessonDTOS = new ArrayList<>();
            lessons.forEach(obj2->{
                LessonDTO lessonDTO = new LessonDTO();
                lessonDTO.setId(obj2.getId());
                lessonDTO.setLessonName(obj2.getLessonName());
                lessonDTO.setMoTa(obj2.getMoTa());
                lessonDTO.setSoGio(obj2.getSoGio());
                lessonDTOS.add(lessonDTO);
            });
            courseDTO.setLessonDTOS(lessonDTOS);
            courseDTOS.add(courseDTO);
        });
        return ResponseEntity.ok(courseDTOS);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CoursesCreateReq coursesCreateReq){
        if(coursesCreateReq.getCourseName() == null){
            return  ResponseEntity.badRequest().body("Can phai dien ten khoa hoc");
        }else if(coursesCreateReq.getSoGio() == 0){
            return ResponseEntity.badRequest().body("So gio phai lon hon 0");
        }
        Courses courses = new Courses();
        courses.setCourseName(coursesCreateReq.getCourseName());
        courses.setSoBuoi(coursesCreateReq.getSoBuoi());
        courses.setSoGio(coursesCreateReq.getSoGio());
        coursesRepository.save(courses);
        return ResponseEntity.ok("them moi course thanh cong");
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                          @RequestBody CoursesUpdateReq coursesUpdateReq){
        if(coursesUpdateReq.getCourseName() == null){
            return ResponseEntity.badRequest().body("can phai dien ten");
        }else if(coursesUpdateReq.getSoGio()== 0){
            return ResponseEntity.badRequest().body("can phai dien so gio > 0");
        }
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
            return ResponseEntity.badRequest().body("Khong tim thay course co id nay: "+id);

    }
}
