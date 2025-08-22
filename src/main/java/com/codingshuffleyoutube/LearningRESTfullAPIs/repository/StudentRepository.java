package com.codingshuffleyoutube.LearningRESTfullAPIs.repository;

import com.codingshuffleyoutube.LearningRESTfullAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


//hme JpaRepository ko extend krana pdta h aur hme Jparepository ko btana pdta h <Entity,type of Entity>

public interface StudentRepository extends JpaRepository<Student, Long> {
}
