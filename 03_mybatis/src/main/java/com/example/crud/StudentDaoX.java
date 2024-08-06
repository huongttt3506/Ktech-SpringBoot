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

    public List<Student> readStudentAll() {
        try (SqlSession session = sessionFactory.openSession()){
            StudentMapperX mapper =
                    session.getMapper(StudentMapperX.class);
            return mapper.selectStudentAll();
        }
    }
}
