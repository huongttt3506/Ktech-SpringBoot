package com.example.jpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "full_name")
    private String name;
    private Integer age;
    private String email;
    private String phone;
    @ManyToOne
//    @JoinColumn(name = "advisor")
    private Instructor advisor;
}
