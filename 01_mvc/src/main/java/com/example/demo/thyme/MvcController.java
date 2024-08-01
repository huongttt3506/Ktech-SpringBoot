package com.example.demo.thyme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
