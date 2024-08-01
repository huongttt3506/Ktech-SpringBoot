package com.example.demo.thyme;

import com.example.demo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
public class MvcController {
    @RequestMapping("text")
    public String text(Model model) {
        // 1. Model에 전달할 데이터를 설정해준다.
        model.addAttribute("name", "Jeeho");
        model.addAttribute("school", "CAU");
        model.addAttribute("major", "MBA");
        model.addAttribute("major", "CSE");
        model.addAttribute("grade", 2.48);
        return "text.html";
    }

    @RequestMapping("text-object")
    public String textObj(Model model) {
        Student alex = new Student(
                "Alex",
                "alex@gmail.com"
        );

        model.addAttribute(
                "student",
                alex
        );
        return "text-object.html";
    }

    @RequestMapping("is-logged-in")
    public String isLoggedIn(Model model) {
        model.addAttribute(
                "isLoggedIn",
                isLoggedIn()
        );
        return "if-unless.html";
    }

    private boolean isLoggedIn() {
        return (new Random()).nextInt() % 2 == 0;
    }

    @RequestMapping("each")
    public String eachNames(Model model) {
        List<String> names = List.of(
                "Alex",
                "Brad",
                "Chad",
                "Dave",
                "Eric",
                "Fred"
        );
        for (String name : names) {
            System.out.println(name);
        }
        model.addAttribute("names", names);

        List<Student> students = List.of(
                new Student("Alex", "alex@gmail.com"),
                new Student("Brad", "brad@gmail.com"),
                new Student("Chad", "chad@gmail.com")
        );
        for (Student student : students) {}
        model.addAttribute("students", students);

        return "each.html";
    }


}
