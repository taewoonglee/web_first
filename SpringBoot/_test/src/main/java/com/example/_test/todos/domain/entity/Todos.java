package com.example._test.todos.domain.entity;

import com.example._test.member.domain.entity.Member;
import com.example._test.todos.domain.request.TodosRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name="todos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Boolean isDone;
    private Integer likeCount;
    @ManyToOne
    private Member member;
    
}