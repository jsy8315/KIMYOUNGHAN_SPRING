package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //0,1,키값을 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
                //null이 반환될 가능성이 있는 경우 optional로 감싼다
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) /*같은 경우에만 필터링*/
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //자바에서 실무할때 리스트 많이 쓴다
        return new ArrayList<>(store.values());
    }
    //이렇게 만든걸 테스트하기 -> test
    public void clearStore() {
        store.clear();
    }
}
