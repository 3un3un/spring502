package org.choongang.tests;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.choongang.entities.Member;
import org.choongang.restcontrollers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import javax.swing.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("회원 가입 성공 시 응답 코드 201")
    void joinTest() throws Exception{
//         MediaType.APPLICATION_JSON == application/json

        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setConfirmPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");
        form.setRegDt(LocalDateTime.now());


        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule()); // 현재 로컬 타임으로 변환
        String body = om.writeValueAsString(form);  // 자바 객체 -> JSON 문자열로 변환

        System.out.println(body);

        mockMvc.perform(
                post("/api/member")
//                        .header("Content-Type", "application/json")
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(body)
                )
                .andDo(print())
                .andExpect(status().isCreated()); // 201이 맞는지 체크

    }

    @Test
    @DisplayName("JSON 문자열 -> Member 객체로 변환")
    void infoTest() throws Exception{
        String body = mockMvc.perform(get("/api/member"))
                .andDo(print()) // 상세 정보 조회
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8")); // body 데이터 가져오기 (인코딩해야 함)

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        Member member = om.readValue(body, Member.class); // JSON -> 객체 readValue(String content, Class<?> cls)
        System.out.println(member);
    }

    @Test
    void listTest() throws Exception {
        String body = mockMvc.perform(get("/api/member/list"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8"));

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        List<Member> members = om.readValue(body, new TypeReference<>() {}); //  readValue(String content, TypeRefernce…)
        members.forEach(System.out::println);

    }


}
