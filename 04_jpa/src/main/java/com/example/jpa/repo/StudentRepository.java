package com.example.jpa.repo;

import com.example.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Long> {
    /*
    SELECT * FROM student WHERE email LIKE '%{?}'
     */
    List<Student> findAllByEmailEndingWith(String email);
}
