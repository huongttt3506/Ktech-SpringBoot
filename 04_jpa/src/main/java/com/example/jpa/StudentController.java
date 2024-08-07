package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 이곳의 모든 요청은 /students 부터 시작했으면
@RequestMapping("students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    // READ ALL
    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("studentList", service.readAll());
        return "students/home.html";
    }

    // /students/{id}
    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("student", service.readOne(id));
        return "students/read.html";
    }

}
