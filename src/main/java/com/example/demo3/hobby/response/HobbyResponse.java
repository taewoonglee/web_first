package com.example.demo3.hobby.response;

import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import lombok.Getter;

@Getter
public class HobbyResponse {
    private Long id;
    private String name;
    private MemberDto members;

    public HobbyResponse(Hobby hobby) {
        this.id = hobby.getId();
        this.name = hobby.getName();
        this.members = new MemberDto(hobby.getMember());
    }

    @Getter
    class MemberDto{
        private Long id;
        private String name;
        private Integer age;

        public MemberDto(Member member) {
            this.id = member.getId();
            this.name = member.getName();
            this.age = member.getAge();
        }
    }
}
