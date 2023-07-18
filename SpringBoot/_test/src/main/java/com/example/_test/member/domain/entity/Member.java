package com.example._test.member.domain.entity;


import com.example._test.todos.domain.entity.Todos;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="members")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<Todos> todosList;

    public Member(String email, String password, String name, Integer age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }
}
