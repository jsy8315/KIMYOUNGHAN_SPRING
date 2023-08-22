package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//스프링이 시작되면, 스프링 컨테이너란 통을 생성함
//"Controller"란 어노테이션을 사용하면(MemberController에)
//MemberController 객체를 생성하여 스프링 컨테이너에 넣어두고, 스프링이 들고 있음(관리를 함)
//이를 "스프링 컨테이너에서, 스프링 빈이 관리된다"라고 표현한다
public class MemberController {
    private final MemberService memberService;
    //memberService를 여러번 만드는 것보다, 한번 만들어서 공용으로 쓰는게 훨씬 좋다
    //한번 만들어서 컨테이너에 등록하고, 공용으로 쓰는게 훨씬 좋다


    @Autowired
    //생성자에 "@Autowired"라고 되어 있으면,
    //MemberController가 생성이 될때
    //스프링빈으로 등록되어 있는 객체를 넣어준다
    //이게바로 DI
    // memberService(Autowired라 되어있는)를 스프링이,
    //스프링 컨테이너에 있는 멤버서비스와 연결 시켜 준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //url~하고 엔터치는 것, 주로 조회할때 사용
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //보통 데이터를 폼 같은데 넣어서 전달할때 주로 사용
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
