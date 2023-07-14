package com.example.demo3.hobby.domain.entity;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="memberhobby")
public class MemberHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hobby hobby;

    public MemberHobby(Member member, Hobby hobby) {
        this.member = member;
        this.hobby = hobby;
    }
}
