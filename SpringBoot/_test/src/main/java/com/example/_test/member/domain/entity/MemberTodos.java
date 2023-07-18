package com.example._test.member.domain.entity;

import com.example._test.member.domain.entity.Member;
import com.example._test.todos.domain.entity.Todos;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="membertodos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MemberTodos
{
        @ManyToOne
        private Member member;
        @OneToMany
        private List<Todos> todosList;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
}
