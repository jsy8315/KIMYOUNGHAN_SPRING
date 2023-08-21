package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//controller는 제일 먼저 거쳐감
//클라이언트의 요청을 처리하고, 응답을 생성하는 역할을 한다
public class HelloController {
    @GetMapping("hello") // HTTP GET요청이 "/hello" 경로로 들어올 때, 'hello'메소드가 실행됨
    //웹애플리케이션에서, "/hello"로 들어오면
    public String hello(Model model) { /*이 메소드를 호출해준다*/
        model.addAttribute("data", "attribute의 value인 hello!");
        //model 객체에 "data"라는 이름의 속성을 추가, 그 값으로 "attribute의 value인 hello!" 문자열 설정
        //뷰이름으로 "hello"를 반환
        return "hello"; //hello.html으로 가서 렌더링하셈
    }

    @GetMapping("hello-mvc")// HTTP GET요청이 "/hello-mvc" 경로로 들어올 때, 'helloMvc'메소드가 실행
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        //requestParam어노테이션을 사용 : URL쿼리 파라미터 중 "name"을 받아옴
        //이렇게 받아온 이름을 "model"객체에 "name"이라는 속성으로 추가,
        //뷰 이름으로 hello-template를 반환(아래에 코드 존재)
        
        //"localhost:8080/hello=mvc?name=꾹이"의 입력에서, name은 "꾹이"로 넘어간다
        //key값은 name
        //String name의 name이
        //"localhost:8080/hello=mvc?name=꾹이"의 꾹이로 바뀐다
        model.addAttribute("name", name);
        //여기의 name도 꾹이로 바뀜, 그리고 모델에 담김
        return "hello-template";
        //hello-template로 넘어간다

    }

    @GetMapping("hello-string")
    @ResponseBody
    //html에 나오는 body가 아님
    //http의 body에 데이터를 직접 넣어주겠다란 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
        //""hello " + name"이 그대로, (뷰 그런거 없다) 데이터를 내려줌
    }

    @GetMapping("hello-api")
    @ResponseBody //http의 응답에 데이터를 그대로 넘겨야겠따!
    public Hello HelloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

