package com.choongang.jpaex;


import com.choongang.entities.BoardData;
import com.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex03Test {

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
    void test1(){
        BoardData data = new BoardData();
        data.setSubject("제목");
        data.setContent("내용");

        //repository.save(data); // persist(data)
        //repository.flush(); // insert 실행
        data = repository.saveAndFlush(data); // persist(data) + flush() 동시에
        // 반환값(data) : 영속 상태

        data.setSubject("(수정)제목");
        //repository.saveAndFlush(data);
        //repository.flush(); // 안나옴. 수정 사항 있는지 ?
        repository.save(data); // 아직 DB에 반영 x
        // save() : 조회 시(findById) 암묵적으로 flush()를 자동으로 먼저 수행한 후에 조회한다.

        BoardData data2 = repository.findById(data.getSeq()).orElse(null);
        System.out.println("data2 = " + data2);
    }

    @Test
    void test2(){
        List<BoardData> items = repository.findAll();
        items.forEach(System.out::println);
    }

}
