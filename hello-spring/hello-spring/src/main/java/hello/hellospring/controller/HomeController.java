package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //localhost:8080으로 처음 들어오면 보이는 곳, "home"으로 넘겨라
    public String home() {
        return "home";
    }
}
