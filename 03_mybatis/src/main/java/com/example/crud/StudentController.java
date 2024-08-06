package com.example.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// 클래스에 RequestMapping을 추가하면
// 각 메서드의 Mapping의 앞에 붙는다.
@RequestMapping("students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // 클래스의 RequestMapping과 합쳐져서 /students/create-view
    @GetMapping("create-view")
    public String createView() {
        return "create-view.html";
    }

    // /students/create
    @PostMapping("create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("age")
            Integer age,
            @RequestParam("phone")
            String phone,
            @RequestParam("email")
            String email
    ) {
        service.create(name, age, phone, email);
        return "redirect:/students";
    }

    // 메서드의 PATH가 지정되지 않으면
    // 클래스 PATH만 사용 (/students)
    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("studentList", service.readAll());
        return "home.html";
    }

    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("student", service.readOne(id));
        return "read.html";
    }

    @GetMapping("{id}/update-view")
    public String updateView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("student", service.readOne(id));
        return "update-view.html";
    }

    @PostMapping("{id}/update")
    public String update(
            @PathVariable("id")
            Long id,
            @RequestParam("name")
            String name,
            @RequestParam("age")
            Integer age,
            @RequestParam("phone")
            String phone,
            @RequestParam("email")
            String email
    ) {
        service.update(
                id,
                name,
                age,
                phone,
                email
        );
        return String.format("redirect:/students/%d", id);
    }
}
