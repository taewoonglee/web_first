package com.example.demo3.hobby.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@Table(name = "members")
@Setter
@ToString
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<MemberHobby> hobbies;

    public Member(String name, Integer age) {
        this.id=getId();
        this.name = name;
        this.age = age;
    }
    public Member() {
    }


}
