package com.example.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("create-view")
    public String createView() {
        return "create.html";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("email")
            String email
    ) {
        service.createStudent(name, email);
        // POST - redirect - GET
        return "redirect:/create-view";

        // Double Post Problem!!!
        // return "create.html";
    }
}
