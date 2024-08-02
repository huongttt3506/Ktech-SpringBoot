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

    public StudentDto readStudent(Long id) {
        for (StudentDto studentDto: studentList) {
            if (studentDto.getId().equals(id)) {
                return studentDto;
            }
        }
        return null;
    }

    public StudentDto updateStudent(
            Long id,
            String name,
            String email
    ) {
        // 찾고 있는 학생의 위치
        int targetIdx = -1;
        // 각 학생을 찾아가며
        for (int i = 0; i < studentList.size(); i++) {
            StudentDto dto = studentList.get(i);
            // 해당 학생의 id가 일치하면
            if (dto.getId().equals(id)) {
                // 저장하고
                targetIdx = i;
                // 종료한다.
                break;
            }
        }
        // 학생을 찾았다면 targetIdx가 더이상 -1이 아닐때
        if (targetIdx != -1) {
            // 대상의 이름과 이메일을 전달받은 데이터로 바꿔준다.
            studentList.get(targetIdx).setName(name);
            studentList.get(targetIdx).setEmail(email);
            // 수정 결과를 반환한다.
            return studentList.get(targetIdx);
        }
        return null;
    }

    public boolean deleteStudent(Long id) {
        // 찾고 있는 학생의 위치
        int targetIdx = -1;
        // 각 학생을 찾아가며
        for (int i = 0; i < studentList.size(); i++) {
            StudentDto dto = studentList.get(i);
            // 해당 학생의 id가 일치하면
            if (dto.getId().equals(id)) {
                // 저장하고
                targetIdx = i;
                // 종료한다.
                break;
            }
        }
        if (targetIdx != -1) {
            studentList.remove(targetIdx);
            return true;
        }
        return false;
    }

}
