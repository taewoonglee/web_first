package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class Hobby {

    private Integer id;
    private String name;
    private Member member;
    private List<MemberHobby> members;


    public Hobby(Integer id,String name, Member member) {
        if(id==null)
        {
            this.id=Store.hobbyIndex++;
        }
        else this.id=id;
        this.name = name;
        this.members=new ArrayList<>();
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
