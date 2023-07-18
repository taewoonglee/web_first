package com.example._test.member.domain.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    private String email;
    private String password;
    private String name;
    private Integer age;

    public MemberRequest(MemberRequest request) {
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.name = request.getName();
        this.age = request.getAge();
    }
}
