package com.example.crud;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentDao dao;

    public StudentService(StudentDao dao) {
        this.dao = dao;
    }

    public void create(
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
        dao.createStudent(student);
    }

    public List<Student> readAll() {
        return dao.readStudentAll();
    }

    public Student readOne(Long id) {
        return dao.readStudent(id);
    }
}
