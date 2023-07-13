package com.example.demo.store;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MemberHobby {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Member member;
    private Hobby hobby;

}
