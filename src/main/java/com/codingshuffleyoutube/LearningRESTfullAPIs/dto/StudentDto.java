package com.codingshuffleyoutube.LearningRESTfullAPIs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String email;

    public StudentDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }



}


//public StudentDto(long l, String akshay, String mail) {
//    this.id=id;
//    this.name=name;
//    this.email=email;
//
//}
