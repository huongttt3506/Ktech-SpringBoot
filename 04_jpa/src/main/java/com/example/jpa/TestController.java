package com.example.jpa;

import com.example.jpa.model.Student;
import com.example.jpa.repo.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    private final StudentRepository repository;
    public TestController(StudentRepository repository) {
        this.repository = repository;
    }

    // /test
    // http://localhost:8080/test
    @GetMapping("test")
    public String test() {
        // CREATE
        Student newStudent = new Student();
        newStudent.setName("Alex");
        newStudent.setEmail("alex@gmail.com");
        System.out.println(newStudent.getId());  // null
        Student saved = repository.save(newStudent);
        System.out.println(saved.getId());
        System.out.println(saved);

        // READ
        Student readOne = repository.findById(1L)
                .orElse(null);
        System.out.println(readOne);
        List<Student> readAll = repository.findAll();
        System.out.println(readAll.size());

        // UPDATE
        Student target = repository.findById(1L)
                .orElseThrow();
        target.setAge(readAll.size());
        repository.save(target);

        // DELETE
        repository.deleteById(2L);
        repository.delete(saved);

        return "test.html";
    }
}
