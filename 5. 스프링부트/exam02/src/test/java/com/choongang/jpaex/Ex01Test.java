package com.choongang.jpaex;


import com.choongang.entities.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01Test {

    @PersistenceContext // autowired 비슷
    private EntityManager em;

    @BeforeEach // 테스트 전 수행
    void init() {
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);
        em.flush();
        em.clear(); // 영속 상태 엔티티 모두 비우기

    }


    @Test
    void test1() {
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member); // 영속성 컨텍스트에 엔티티를 영속 : 상태 감지 시작
        em.flush(); //  DB 반영
        /// insert 처리

        em.detach(member); // 영속성 분리 - 변화 감지 x
        /// 다음 코드들이 수행되지 않는다.

        member.setName("(수정)사용자01");
        em.flush();
        /// update 처리

        em.merge(member); // 분리된 영속 상태를 다시 영속 상태로 - 변화 감지 o
        // select로 변화 상태가 있는지 비교 후 update 수행
        em.flush();

        em.remove(member); // 영속성 상태를 제거
        em.flush();
        /// delete 처리



    }


    // find 메서드
    @Test
    void test2() {
        Member member = em.find(Member.class, 1L); // 영속 상태 x -> SQL 실행 -> 엔티티를 영속 상태로
        System.out.println("member = " + member);

        Member member2 = em.find(Member.class, 1L); // 영속 상태 엔티티 바로 조회 (쿼리 실행 x)
        System.out.println("member2 = " + member2);


    }

    // JPQL 사용하기
    @Test
    void test3() {
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
        members.forEach(System.out::println);

    }


}
