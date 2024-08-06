package com.example.crud;

import com.example.crud.mapper.StudentMapperX;
import com.example.crud.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// XML과 interface를 연결한 MyBatis DAO
public class StudentDaoX {
    private final SqlSessionFactory sessionFactory;

    public StudentDaoX(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createStudent(Student student) {
        try (SqlSession session = sessionFactory.openSession()) {
            StudentMapperX mapper =
                    session.getMapper(StudentMapperX.class);
            mapper.insertStudent(student);
        }
    }

    public List<Student> readStudentAll() {
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapper =
                    session.getMapper(StudentMapperX.class);
            return mapper.selectStudentAll();
        }
    }

    public Student readStudent(Long id) {
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapper =
                    session.getMapper(StudentMapperX.class);
            return mapper.selectStudent(id);
        }
    }

    public void updateStudent(Student student) {
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapper =
                    session.getMapper(StudentMapperX.class);
            mapper.updateStudent(student);
        }
    }

    public void deleteStudent(Long id) {
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapper =
                    session.getMapper(StudentMapperX.class);
            mapper.deleteStudent(id);
        }
    }
}
