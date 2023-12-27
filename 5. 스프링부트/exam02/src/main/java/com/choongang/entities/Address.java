package com.choongang.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Address {
    @Id @GeneratedValue
    private Long seq;

    @Column(length=10, nullable = false)
    private String zipcode;

    @Column(length = 80, nullable = false)
    private String addr1;

    @Column(length = 80)
    private String addr2;

    @ToString.Exclude // StackOverflowError 해결 방안, member가 더 중요함->address에서 처리
    @OneToOne(mappedBy = "address")
    private Member member;

}
