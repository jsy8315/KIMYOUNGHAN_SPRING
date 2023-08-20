package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//controller는 제일 먼저 거쳐감
public class HelloController {
    @GetMapping("hello") //웹애플리케이션에서, "/hello"로 들어오면
    public String hello(Model model) { /*이 메소드를 호출해준다*/
        model.addAttribute("data", "attribute의 value인 hello!");
        return "hello"; //hello.html으로 가서 렌더링하셈
    }
}
