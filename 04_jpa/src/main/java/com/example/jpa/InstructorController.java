package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// /instructors
@RequestMapping("instructors")
public class InstructorController {
    private final InstructorService service;
    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("instructorList", service.readAll());
        return "instructors/home.html";
    }
}
