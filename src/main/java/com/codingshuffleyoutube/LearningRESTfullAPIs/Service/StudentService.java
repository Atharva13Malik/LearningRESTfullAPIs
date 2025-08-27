package com.codingshuffleyoutube.LearningRESTfullAPIs.Service;

import com.codingshuffleyoutube.LearningRESTfullAPIs.dto.AddStudentRequestDto;
import com.codingshuffleyoutube.LearningRESTfullAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(String id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatepartialStudent(Long id, Map<String,Object> updates);
}
