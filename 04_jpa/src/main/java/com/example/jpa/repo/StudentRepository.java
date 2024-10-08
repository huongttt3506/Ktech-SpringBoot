package com.example.jpa.repo;

import com.example.jpa.model.Instructor;
import com.example.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Long> {
    /*
    SELECT * FROM student WHERE email LIKE '%{?}'
     */
    List<Student> findAllByEmailEndingWith(String email);
    List<Student> findAllByAdvisor(Instructor advisor);
    List<Student> findAllByAdvisorId(Long advisorId);
    List<Student> findAllByAdvisorLastName(String lastName);
}
