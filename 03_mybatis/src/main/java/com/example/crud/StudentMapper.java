package com.example.crud;

import com.example.crud.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

// MyBatis는 interface의 메서드와 SQL을 연결해준다.
@Mapper
public interface StudentMapper {
    // 여러가지 Annotation을 통해
    // 다양한 SQL 구문을 실행할 수 있다.
    @Insert("INSERT INTO student(name, email, age, phone) " +
            "VALUES(#{name}, #{email}, #{age}, #{phone});")
    void insertStudent(Student student);

    @Select("SELECT * FROM student;")
    List<Student> selectStudentAll();

    @Select("SELECT * FROM student WHERE id = #{id};")
    Student selectStudent(Long id);

    @Update("""
            UPDATE student SET
                name = #{name},
                email = #{email},
                age = #{age},
                phone = #{phone}
            WHERE id = #{id};
            """)
    void updateStudent(Student student);

    @Delete("DELETE FROM student " +
            "WHERE id = #{id};")
    void deleteStudent(Long id);
}
