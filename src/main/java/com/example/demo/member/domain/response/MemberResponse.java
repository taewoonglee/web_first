package com.example.demo.member.domain.response;

import com.example.demo.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor @Getter
public class MemberResponse {
    private Long id;
    private String name;
    private Integer age;
    public MemberResponse(Member member){
        this.id = member.getId();
        this.age = member.getAge();
        this.name = member.getName();
    }
}
