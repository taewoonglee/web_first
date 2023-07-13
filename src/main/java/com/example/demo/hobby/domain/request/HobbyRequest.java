package com.example.demo.hobby.domain.request;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HobbyRequest {
    private String name;
    public Hobby toEntity(){
        return new Hobby(null,
                name,
                new Member(1l,null,null,null));
    }
}
