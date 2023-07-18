package com.example._test.like.domain.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="likes")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer memberId;
    private Integer todoId;

    public Like(Integer memberId, Integer todoId) {
        this.memberId = memberId;
        this.todoId = todoId;
    }
}
