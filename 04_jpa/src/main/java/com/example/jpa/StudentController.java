package com.example.jpa;

import com.example.jpa.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// 이곳의 모든 요청은 /students 부터 시작했으면
@RequestMapping("students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    // CREATE
    @GetMapping("create")
    public String createView() {
        return "students/create.html";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("age")
            Integer age,
            @RequestParam("phone")
            String phone,
            @RequestParam("email")
            String email,
            @RequestParam("advisor-id")
            Long advisorId
    ) {
        Student created = service.create(
                name,
                age,
                phone,
                email,
                advisorId
        );
        return String.format("redirect:/students/%d", created.getId());
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
