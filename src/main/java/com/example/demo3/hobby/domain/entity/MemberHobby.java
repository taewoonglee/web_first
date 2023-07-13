package com.example.demo3.hobby.domain.entity;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="memberhobby")
public class MemberHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Hobby hobby;

    public MemberHobby(Member member, Hobby hobby) {
        this.member = member;
        this.hobby = hobby;
    }

    public MemberHobby() {

    }
}