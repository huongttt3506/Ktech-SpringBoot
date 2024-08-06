package com.example.crud;

import com.example.crud.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

// DB 연결을 활용해
// Mapper interface를 실제로 사용하는 클래스
@Repository
public class StudentDao {
    // MyBatis와 데이터베이스의 연결을 담당하는 객체
    private final SqlSessionFactory sessionFactory;

    public StudentDao(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createStudent(Student student) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentMapper mapper =
                    session.getMapper(StudentMapper.class);
            mapper.insertStudent(student);
        }
    }

    public List<Student> readStudentAll() {
        // sqlSession을 try - with - resource로 만든다.
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapper mapper =
                    session.getMapper(StudentMapper.class);
            return mapper.selectStudentAll();
        }
    }

    public Student readStudent(Long id) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentMapper mapper =
                    session.getMapper(StudentMapper.class);
            return mapper.selectStudent(id);
        }
    }

    public void updateStudent(Student student) {
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapper mapper =
                    session.getMapper(StudentMapper.class);
            mapper.updateStudent(student);
        }
    }

    public void deleteStudent(Long id) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentMapper mapper =
                    session.getMapper(StudentMapper.class);
            mapper.deleteStudent(id);
        }
    }
}
