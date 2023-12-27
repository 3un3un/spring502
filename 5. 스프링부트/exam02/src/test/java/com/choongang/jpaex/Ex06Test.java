package com.choongang.jpaex;

import com.choongang.entities.BoardData;
import com.choongang.entities.Member;
import com.choongang.entities.QBoardData;
import com.choongang.repositories.BoardDataRepository;
import com.choongang.repositories.MemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test") // test, 없으면 oracle에 적용
public class Ex06Test {

    @Autowired
    private BoardDataRepository boardDataRepository;
    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        memberRepository.saveAndFlush(member);

        List<BoardData> items = new ArrayList<>();
        for(int i=1; i<=10; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setMember(member);
            items.add(item);
        }
        boardDataRepository.saveAllAndFlush(items);
        em.clear(); // 엔티티 비우기

/*        BoardData data = new BoardData();
        data.setSubject("제목1");
        data.setContent("내용1");
        data.setMember(member);

        boardDataRepository.saveAndFlush(data);*/
    }

    @Test
    void test1(){
        BoardData data = boardDataRepository.findById(1L).orElse(null);
        Member member = data.getMember();
        String email = member.getEmail(); // 2차 쿼리 수행
        System.out.println("email = " + email);
        //System.out.println("member : " + member);

    }

    @Test
    void test2() {
        Member member = memberRepository.findByEmail("user01@test.org");
        List<BoardData> items = member.getItems();
        System.out.println("member = " + member);
        System.out.println("items = " + items);
        items.forEach(System.out::println); // BoardData -> toString() 참조변수 호출 시 알아서 toString()


    }
    @Test
    void test3() {
        List<BoardData> items = boardDataRepository.findAll(); // 1차 쿼리 실행
        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail(); // 2차 쿼리 실행
        }
    }

    @Test
    void test4() {
//        List<BoardData> items = boardDataRepository.getSubjects("목");
        List<BoardData> items = boardDataRepository.findBySubjectContaining("목");

    }

    @Test
    void test5(){
        QBoardData boardData = QBoardData.boardData;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        List<BoardData> items = jpaQueryFactory.selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin()
                .where(boardData.subject.contains("목"))
                .fetch();

        items.forEach(System.out::println);



    }

}
