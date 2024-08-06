package com.example.crud.mapper;

import com.example.crud.model.Student;

import java.util.List;

public interface StudentMapperX {
    // 메서드 이름과 동일한 id를 가진 XML SQL이 연결된다.
    void insertStudent(Student student);
    List<Student> selectStudentAll();
    Student selectStudent(Long id);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}
