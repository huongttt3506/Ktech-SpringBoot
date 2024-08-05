package com.example.crud;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// MyBatis는 interface의 메서드와 SQL을 연결해준다.
@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    List<Student> selectStudentAll();
}
