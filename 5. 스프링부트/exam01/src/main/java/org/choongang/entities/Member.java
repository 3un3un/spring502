package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor // builder(private) 사용하면서 기본 생성자 가능하도록 설정
public class Member {
    // USER_NO(db) -> userNo ok
    @Id // 기본키를 필수로 알려줘야 한다.
    private Long userNo;
    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNm;
    private String email;
    @JsonFormat(pattern="yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;

}
