package com.example.jpa;

import com.example.jpa.model.Instructor;
import com.example.jpa.repo.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository repository;
    public InstructorService(InstructorRepository repository) {
        this.repository = repository;
    }

    // READ
    public List<Instructor> readAll() {
        return repository.findAll();
    }

    public Instructor readOne(Long id) {
        // findById는 Optional을 반환한다.
        return repository.findById(id)
                .orElse(null);
    }

}
