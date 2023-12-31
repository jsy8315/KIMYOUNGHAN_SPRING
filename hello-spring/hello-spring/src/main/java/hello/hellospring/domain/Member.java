package hello.hellospring.domain;

import javax.persistence.*;

@Entity //이제부터 JPA가 관리하는 엔티티!
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //시스템이 저장하는 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
