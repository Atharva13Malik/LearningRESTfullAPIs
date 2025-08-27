package com.codingshuffleyoutube.LearningRESTfullAPIs.controller;


import com.codingshuffleyoutube.LearningRESTfullAPIs.Service.StudentService;
import com.codingshuffleyoutube.LearningRESTfullAPIs.dto.AddStudentRequestDto;
import com.codingshuffleyoutube.LearningRESTfullAPIs.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")


public class StudentController {

    // @Atutowired kmm use kro , Constructor dependency injection hi use kro

    private  StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //private final StudentRepository studentRepository;



//    public StudentController(StudentRepository, StudentService) {
//        this.studentService = studentService;
//        this.studentRepository = studentRepository;
//    }//hmne studentrepository ka bean object bna diya


    //Response entity se hmm different cheez return kra skte h n

    @GetMapping// produces = "application/json")
    public ResponseEntity<List<StudentDto>> getStudent() {

        return ResponseEntity.ok(studentService.getAllStudents());
       // return studentService.getAllStudents();
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
//        Student = studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
//
//        return new StudentDto(student.getId(), student.getName(), student.getEmail());
//    }

//    @GetMapping(value = "/student/{id}", produces = "application/json")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
//    }



    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){

       return ResponseEntity.ok(studentService.getStudentById(String.valueOf(id)));
        // return studentService.getStudentById(String.valueOf(id));


//    @GetMapping("/student/{id}")
//    public StudentDto getStudentById(@PathVariable String id,@PathVariable String name){
//
//        return "path variable" +id+" name is"+name;

        //return studentService.getStudentById(id);
        //return "Path variable" +id;
        //return new StudentDto(4L,"Anuj","anuj@gmail.com");
    }



//    @PostMapping(value = "/student", consumes = "application/json", produces = "application/json")
//    public Student createStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//    }


    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,@RequestBody AddStudentRequestDto addStudentRequestDto){

        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatepartialStudent(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return ResponseEntity.ok(
                studentService.updatepartialStudent(id, updates)
        );
    }



}



