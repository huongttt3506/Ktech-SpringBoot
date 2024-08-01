package com.example.demo;

import com.example.demo.temp.TempComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 사용자의 요청을 처리하는 기능이 담긴
// Component 어노테이션
@Controller
public class DemoController {
    // new를 통해서 TempComponent를 만들면 그냥 만드는 코드가 되지만
//    private TempComponent tempComponent = new TempComponent();
    private TempComponent tempComponent;

    // 생성자를 통해 TempComponent를 전달받으면
    // Spring이 만든 Bean 객체를 사용하게 된다.
    public DemoController(TempComponent tempComponent) {
        this.tempComponent = tempComponent;
    }

    @RequestMapping("home")
    public String home() {
        tempComponent.sayHello();
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
