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

    public void update(
            Long id,
            String name,
            Integer age,
            String phone,
            String email
    ) {
        // 1. 원래 데이터를 가져온다.
        Student target = dao.readStudent(id);
        // 2. 전달받은 데이터로 원래 데이터를 바꿔준다.
        target.setName(name);
        target.setAge(age);
        target.setPhone(phone);
        target.setEmail(email);
        // 3. dao에 저장하도록 넘겨준다.
        dao.updateStudent(target);
    }
}
