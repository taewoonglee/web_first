package com.example.demo3.hobby.response;

import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.entity.Member;
import com.example.demo3.hobby.domain.entity.MemberHobby;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HobbyResponse {
    private Long id;
    private String name;
    private List<MemberDto> members;

    public HobbyResponse(Hobby hobby) {
        this.id = hobby.getId();
        this.name = hobby.getName();
        this.members=hobby.getMembers().stream()
                .map(h->h.getMember())
                .map(m->new MemberDto(m))
                .toList();
        //중요한내용
    }

    @Getter
    class MemberDto{
        private Long id;
        private String name;
        private Integer age;
        public MemberDto(Member member){
            this.id=member.getId();
            this.name = member.getName();
            this.age= member.getAge();
        }
    }
}
