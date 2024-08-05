package com.example.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    private StudentDao dao;
    public StudentController(StudentDao dao) {
        this.dao = dao;
    }

    @RequestMapping("test")
    public String test() {
        System.out.println(dao.readStudentAll());
        return "test.html";
    }
}
