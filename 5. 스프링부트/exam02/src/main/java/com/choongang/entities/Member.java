package com.choongang.entities;

import com.choongang.commons.MemberType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.Internal;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="USERS", // index : 엔티티 기준 이름으로 설정
        indexes = @Index(name="idx_member_createdAt", columnList = "createdAt DESC"))
// @CreatedDate, @LastModifiedDate 사용 - 변화 감지를 위한 이벤트 리스너
//@EntityListeners(AuditingEntityListener.class)
public class Member extends Base{
    @Id @GeneratedValue
    private Long seq;
    //@Column(unique = true, nullable = false); // Unique 제약 조건
    @Column(length=80)
    private String email;
    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 65, nullable = false) // db 칼럼 이름 userPw로 사용
    private String password;
    // String(varchar2) -> large object로 사용(여러 줄 텍스트 입력할 때)
    // @Lob // oracle에서 CLOB 으로
    @Transient  // 해당 필드 데이터베이스 매핑 무시
    private String introduction;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberType type;

    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) // 1:N 관계
    private List<BoardData> items = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY) // 1:1 관계, fetch : Join
    @JoinColumn(name="addressNo") // 외래키 이름 설정 - 1:1 관계이므로 unique 자동 추가
    private Address address; // 외래키 제약 조건 생성




/*    @CreationTimestamp // INSERT SQL 실행 시
    private LocalDateTime createdAt;
    @UpdateTimestamp // UPDATE SQL 실행 시
    private LocalDateTime modifiedAt;*/


//    @Temporal(TemporalType.DATE) // 날짜
//    @Temporal(TemporalType.TIME) // 시간
//    @Temporal(TemporalType.TIMESTAMP) // 날짜 + 시간
//    public Date dt;

}
