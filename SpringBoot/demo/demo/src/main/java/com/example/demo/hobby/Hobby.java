package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Hobby {

    private Integer id;
    private String name;
    private Member member;

    public Hobby(String name, Member member) {
        this.id = Store.hobbyIndex++;
        this.name = name;
        this.member = member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
