package com.example.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private final List<StudentDto> students = new ArrayList<>();
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
        System.out.println(name);
        System.out.println(email);
        students.add(new StudentDto(null, name, email));
        System.out.println(students);

        // POST - redirect - GET
        return "redirect:/create-view";

        // Double Post Problem!!!
        // return "create.html";
    }
}
