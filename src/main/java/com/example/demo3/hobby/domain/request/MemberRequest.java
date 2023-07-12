package com.example.demo3.hobby.domain.request;


import jakarta.persistence.Table;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "members")
@Setter
public class MemberRequest {
    private String name;
    private Integer age;

}
