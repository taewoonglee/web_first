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
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "member")
    private List<Hobby> hobbies;

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Member() {
    }


}
