package com.codingshuffleyoutube.LearningRESTfullAPIs.Service.impl;

import com.codingshuffleyoutube.LearningRESTfullAPIs.Service.StudentService;
import com.codingshuffleyoutube.LearningRESTfullAPIs.dto.AddStudentRequestDto;
import com.codingshuffleyoutube.LearningRESTfullAPIs.dto.StudentDto;
import com.codingshuffleyoutube.LearningRESTfullAPIs.entity.Student;
import com.codingshuffleyoutube.LearningRESTfullAPIs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service  //Yha buisness logic likha jayega
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {  // StudentServiceimpl ,ye wali class hmari studentrepository(persistence) layer se baat kregi

    private StudentRepository studentRepository;
    public void StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private  ModelMapper modelMapper;

    public StudentServiceimpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students=studentRepository.findAll();
        List<StudentDto> studentDtoList=students
                .stream()
                .map(student
                        -> new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();
        return studentDtoList;
    }

    //Hmne yha straem API usse ki h na ki modelmapper class to convert Students to studentdto

    @Override
    public StudentDto getStudentById(String id) {
        return null;
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent=modelMapper.map(addStudentRequestDto,Student.class);
        Student student=studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id"+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with ID"+id));
        modelMapper.map(addStudentRequestDto,student);
        
        student =studentRepository.save(student);
        return modelMapper(student,StudentDto.class);
    }

    @Override
    public StudentDto updatepartialStudent(Long id, Map<String, Object> updates) {
        Student student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not Found with ID"));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name" -> student.setName((String) value);
                case "email" -> student.setEmail((String) value);
                default -> throw new IllegalArgumentException("Unknown field: " + field);
            }
        });

        Student savedStudent =studentRepository.save(student);
        return modelMapper(savedStudent,StudentDto.class);

    }

    private StudentDto modelMapper(Student student, Class<StudentDto> studentDtoClass) {
        return modelMapper.map(student, studentDtoClass);
    }


    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with ID: "+id));
        StudentDto studentDto=modelMapper.map(student,StudentDto.class);
        return studentDto;


        //Hmne student ko studentDto meh convert kiya with the help of map method from the modelMapper class
    }



    // Hamra ye method List<StudentDto>, iss type ka h that means we have to return a list of StudentDto,there  we convert student to stream
    // ,inside the stream hmm ek ek student pe gye aur hmne ek ke slement mtlb ek ek student ko student dto meh convert krdiya,
    // fir student Dto ki stream ko hmne List meh convert krdiya
}
