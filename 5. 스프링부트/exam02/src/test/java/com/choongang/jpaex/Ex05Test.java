package com.choongang.jpaex;

import com.choongang.entities.BoardData;
import com.choongang.entities.QBoardData;
import com.choongang.repositories.BoardDataRepository;
import com.querydsl.core.BooleanBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex05Test {

    @Autowired
    private BoardDataRepository repository;

    @BeforeEach
    void init(){
        List<BoardData> items = new ArrayList<>();
        for(int i=1; i<=10; i++){
            BoardData item = new BoardData();
            item.setSubject("제목"+i);
            item.setContent("내용"+i);
            items.add(item);
        }
        repository.saveAllAndFlush(items);
    }

    @Test
    void test1() {
        List<BoardData> items = repository.getSubjects("목");
        items.forEach(System.out::println);


    }
    @Test
    void test2() {
                QBoardData boardData = QBoardData.boardData;

        List<BoardData> items = (List<BoardData>)repository.findAll(boardData.subject.contains("목"));

        items.forEach(System.out::println);
    }

    @Test
    void test3() {
        QBoardData boardData = QBoardData.boardData;
        List<BoardData> items = (List<BoardData>)repository.findAll(boardData.subject.contains("목"), Sort.by(desc("createdAt")));

        items.forEach(System.out::println);
    }

    @Test
    void test4() {
        QBoardData boardData = QBoardData.boardData;

        Pageable pageable = PageRequest.of(1, 3,Sort.by(desc("createdAt")));

        Page<BoardData> data = repository.findAll(boardData.subject.contains("목"), pageable);
    }

    @Test
    void test5() {
        QBoardData boardData = QBoardData.boardData;
        BooleanBuilder andBuilder = new BooleanBuilder();
        BooleanBuilder orBuilder = new BooleanBuilder();

        andBuilder.and(boardData.seq.in(1L, 3L, 5L));

        orBuilder.or(boardData.subject.contains("목"))
                .or(boardData.Content.contains("용"));

        // OR과 AND 함께 -> 괄호 쓰기. 참이 되면 뒤에 검사 x
        // (subject LIKE '%목%' OR content LIKE '%목%') AND seq IN (1, 3, 5);
        // 범위가 좁혀질 수 있게 AND 부터 사용 권장
        andBuilder.and(orBuilder);



        List<BoardData> items = (List<BoardData>) repository.findAll(andBuilder);
        items.forEach(System.out::println);
    }





}
