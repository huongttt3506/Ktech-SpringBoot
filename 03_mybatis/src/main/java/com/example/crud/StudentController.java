package com.example.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("create-view")
    public String createView() {
        return "create-view.html";
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
            String email
    ) {
        service.create(name, age, phone, email);
        return "redirect:/create-view";
    }

//    public StudentController(StudentDao dao) {
//        this.dao = dao;
//    }

//    @RequestMapping("test")
//    public String test() {
////        dao.createStudent(new Student(
////                null,
////                "alex",
////                19,
////                "01000000000",
////                "alex@gmail.com"
////        ));
//        System.out.println(dao.readStudentAll());
//        System.out.println(dao.readStudent(1L));
//
//        Student alex = dao.readStudent(1L);
//        alex.setAge(alex.getAge() == 10 ? 20 : 10);
//        alex.setEmail(alex.getEmail().endsWith("gmail.com") ? "alex@naver.com" : "alex@gmail.com");
//        dao.updateStudent(alex);
//        System.out.println(dao.readStudent(1L));
//
//        dao.deleteStudent(2L);
//
//        return "test.html";
//    }
}
