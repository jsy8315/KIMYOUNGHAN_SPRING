package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service //서비스임을 인지하여, 스프링이 (객체를 생성하여) 스프링 컨테이너에 (스프링 빈으로)등록해줌
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //ctrl + shift + t로 테스트 클래스 손쉽게 생성 가능
    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원은 안됨
        validateDuplicateMemeber(member);//중복회원 검증
        memberRepository.save((member));
        return member.getId();

    }

    private void validateDuplicateMemeber(Member member) {//Extract Method로 빼준다
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member>findOne(long memberId) {
        return memberRepository.findById(memberId);
    }
}
