package com.example.demo3.hobby.domain.entity;


import com.example.demo3.hobby.domain.request.HobbyRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    @OneToMany(mappedBy ="hobby")
    private List<MemberHobby> members;
//
//    public Hobby(HobbyRequest request,Member member) {
//        this.name = request.getName();
//        this.member = member;
//    }

}
