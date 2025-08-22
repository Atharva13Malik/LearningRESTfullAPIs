package com.codingshuffleyoutube.LearningRESTfullAPIs.controller;


import com.codingshuffleyoutube.LearningRESTfullAPIs.dto.StudentDto;
import com.codingshuffleyoutube.LearningRESTfullAPIs.entity.Student;
import com.codingshuffleyoutube.LearningRESTfullAPIs.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    // @Atutowired kmm use kro , Constructor dependency injection hi use kro

    private final StudentRepository studentRepository;



    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }//hmne studentrepository ka bean object bna diya

    @GetMapping(value = "/student")// produces = "application/json")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
//
//      // return new StudentDto(4,"Atharva","atharvasanjaymalik@gmail.com");
//
//    }  //pehle hmm yha StudentDto return krare the ab yha list of StudentDto return krare h

//    @GetMapping(value = "/student/{id}",produces ="application/json")
//    public StudentDto getStudentbyId(){
//        return new StudentDto(5L,"Akshay","atharva.2327cs122@kiet.edu");
//    }

//    @GetMapping(value = "/student/{id}" ), produces = "application/json")
//    public StudentDto getStudentbyId(@PathVariable Long id) {
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
//
//        return new StudentDto(student.getId(), student.getName(), student.getEmail());
//    }

    @GetMapping(value = "/student/{id}", produces = "application/json")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }


//    @PostMapping(value = "/student", consumes = "application/json", produces = "application/json")
//    public Student createStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//    }


}



