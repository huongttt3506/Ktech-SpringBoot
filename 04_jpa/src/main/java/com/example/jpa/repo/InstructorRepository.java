package com.example.jpa.repo;

import com.example.jpa.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository
        extends JpaRepository<Instructor, Long> {}
