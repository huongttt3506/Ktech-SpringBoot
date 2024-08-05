package com.example.crud;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// MyBatis는 interface의 메서드와 SQL을 연결해준다.
@Mapper
public interface StudentMapper {
    // 여러가지 Annotation을 통해
    // 다양한 SQL 구문을 실행할 수 있다.
    @Insert("INSERT INTO student(name, email, age, phone) " +
            "VALUES(#{name}, #{email}, #{age}, #{phone});")
    void insertStudent(Student student);

    @Select("SELECT * FROM student")
    List<Student> selectStudentAll();
}
