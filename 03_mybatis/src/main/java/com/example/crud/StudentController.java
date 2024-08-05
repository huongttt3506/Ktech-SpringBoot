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
//        dao.createStudent(new Student(
//                null,
//                "alex",
//                19,
//                "01000000000",
//                "alex@gmail.com"
//        ));
        System.out.println(dao.readStudentAll());
        System.out.println(dao.readStudent(1L));
        System.out.println(dao.readStudent(2L));
        return "test.html";
    }
}
