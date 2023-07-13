package com.example.demo3.hobby.response;

import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class MemberResponse {
    private Long id;
    private String name;
    private Integer age;
    private List<HobbyDto> hobbies = new ArrayList<>();

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
       this.hobbies=member.getHobbies().stream().map(HobbyDto::new).toList();
    }
    @Getter
    @AllArgsConstructor
    class HobbyDto{
        private Long id;
        private String name;

        public HobbyDto(Hobby hobby) {
            this.id = hobby.getId();
            this.name = hobby.getName();
        }
        public HobbyDto toDto(Hobby hobby)
        {
            return new HobbyDto(hobby.getId(),hobby.getName());
        }

    }
}
