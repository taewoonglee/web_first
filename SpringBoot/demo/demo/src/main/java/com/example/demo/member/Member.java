package com.example.demo.member;


import com.example.demo.hobby.Hobby;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//테이블 임
public class Member {
    private Integer id;
    private String name;
    private Integer age;
    private List<MemberHobby> hobbies = new ArrayList<>();



    public Member(String name, Integer age) {
        this.id= Store.memberIndex++;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<MemberHobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<MemberHobby> hobbies) {
        this.hobbies = hobbies;
    }
}
