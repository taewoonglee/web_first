package com.example.demo.hobby;

import com.example.demo.member.Member;

public record HobbyRequest(String name,Member member) {
    public Hobby toEntity(){

        return new Hobby(name,member);
    }
}

