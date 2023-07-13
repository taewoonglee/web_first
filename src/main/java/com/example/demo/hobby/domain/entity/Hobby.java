package com.example.demo.hobby.domain.entity;


import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

// jakarta.persistence api
// jpa
@Entity
@Getter @AllArgsConstructor
@NoArgsConstructor @Builder
@Setter
@Table(name = "hobbies")
public class Hobby {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Member member;
}
