package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//controller는 제일 먼저 거쳐감
public class HelloController {
    @GetMapping("hello") //웹애플리케이션에서, "/hello"로 들어오면
    public String hello(Model model) { /*이 메소드를 호출해준다*/
        model.addAttribute("data", "attribute의 value인 hello!");
        return "hello"; //hello.html으로 가서 렌더링하셈
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        //"localhost:8080/hello=mvc?name=꾹이"의 입력에서, name은 "꾹이"로 넘어간다
        //key값은 name
        //String name의 name이
        //"localhost:8080/hello=mvc?name=꾹이"의 꾹이로 바뀐다
        model.addAttribute("name", name);
        //여기의 name도 꾹이로 바뀜, 그리고 모델에 담김
        return "hello-template";
        //hello-template로 넘어간다
    }
}
