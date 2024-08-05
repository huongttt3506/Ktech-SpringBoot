package com.example.crud;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// DB와 직접적으로 소통하는 역할
@Repository
public class StudentRepository {
    // DB와의 연결을 상징하는 객체
    private final Connection connection;

    // 생성자에서 DB와 연결을 진행한다.
    public StudentRepository() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Student 생성
    public void create(StudentDto dto) {
        String insertSql = """
                INSERT INTO student(name, email)
                VALUES (?, ?);
                """;

        try (PreparedStatement statement
                     = connection.prepareStatement(insertSql)) {
            statement.setString(1, dto.getName());
            statement.setString(2, dto.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
