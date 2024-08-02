package com.example.crud;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    // 마지막 사용된 id를 보관할 변수
    private Long nextId = 1L;
    private final List<StudentDto> studentList = new ArrayList<>();

    public StudentDto createStudent(
            String name,
            String email
    ) {
        StudentDto newStudent = new StudentDto(nextId, name, email);
        System.out.println(newStudent);
        nextId++;
        studentList.add(newStudent);
        return newStudent;
    }

    public List<StudentDto> readAllStudents() {
        return studentList;
    }
}
