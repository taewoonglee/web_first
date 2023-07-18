package com.example.demo.store;

import com.example.demo.hobby.Hobby;
import com.example.demo.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
public class MemberHobby {
    private Member members;
    private Hobby hobby;

    public MemberHobby(Member members, Hobby hobby) {
        this.members = members;
        this.hobby = hobby;
        members.getHobbies().add(this);
        hobby.getMembers().add(this);
    }
}
