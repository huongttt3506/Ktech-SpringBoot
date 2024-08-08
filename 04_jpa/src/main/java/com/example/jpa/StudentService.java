package com.example.jpa;

import com.example.jpa.model.Student;
import com.example.jpa.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Student create(
            String name,
            Integer age,
            String phone,
            String email
    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setPhone(phone);
        student.setEmail(email);
        return repository.save(student);
    }

    // READ
    public List<Student> readAll() {
        return repository.findAll();
    }

    public Student readOne(Long id) {
        Optional<Student> student = repository.findById(id);
        return student.orElse(null);
    }
}
