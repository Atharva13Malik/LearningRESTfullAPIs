package com.codingshuffleyoutube.LearningRESTfullAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AddStudentRequestDto {
    @Data

    @NoArgsConstructor
    public class StudentDto {
       // private long id;
        private String name;
        private String email;

        public StudentDto( String name, String email) {
           // this.id = id;
            this.name = name;
            this.email = email;
        }



    }
}
