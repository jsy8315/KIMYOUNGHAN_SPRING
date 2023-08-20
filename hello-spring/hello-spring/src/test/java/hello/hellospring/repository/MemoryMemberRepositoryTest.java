package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    //테스트는 서로 의존관계가 없어야됨
    //그래서 공용 데이터 같은 것들을 깔끔하게 지워줘야함
    @Test
    public void save(){
        Member member = new Member();
        member.setName("정수영");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //타입이 option은 get()으로 바로 꺼낼수있다
        assertThat(member).isEqualTo(result);
        //member가 result와 똑같?
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("정수일");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("정수이");
        repository.save(member2);

        Member result = repository.findByName("정수일").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("정수일");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("정수이");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
    //테스트 먼저하기(틀을 만들기) ttd (테스트 주도 개발)
}
