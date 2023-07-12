package com.example.demo3.hobby.domain.entity;


import jakarta.persistence.*;
import lombok.*;
//jakarta.persistence api

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hobbies")
@Setter
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Hobby(String name) {
        this.name = name;
    }
}
