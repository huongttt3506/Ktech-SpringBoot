package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("home")
    public String home() {
        return "home.html";
    }

    @RequestMapping("profile")
    public String profile() {
        return "profile.html";
    }

    @RequestMapping("address")
    public String address() {
        return "address.html";
    }
}
