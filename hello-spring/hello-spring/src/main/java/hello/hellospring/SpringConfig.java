package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//스프링이 뜰때, 이 "@Configuration"을 읽고
public class SpringConfig {
    @Bean //?스프링 bean에 등록하라는 뜻이네?라고 인식하고
    public MemberService memberService() {
        return new MemberService(memberRepository()); //이 로직을 호출해서, 스프링 bean에 등록을 해줌
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    //memberService와 memberRepository 둘다 spring bean에 등록한다
    //스프링 bean에 등록된 memberRepository를 memberService에 넣어준다

}
