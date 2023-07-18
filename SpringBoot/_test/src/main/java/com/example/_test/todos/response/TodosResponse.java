package com.example._test.todos.response;


import com.example._test.member.domain.entity.Member;
import com.example._test.todos.domain.entity.Todos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TodosResponse {
    private Integer id;
    private String title;
    private String content;
    private Boolean isDone;
    private Integer likeCount;
    private MemberDto member;

    public TodosResponse(Todos todos) {
        this.id = todos.getId();
        this.title = todos.getTitle();
        this.content =todos.getContent();
        this.isDone =todos.getIsDone() ;
        this.likeCount = todos.getLikeCount();
        this.member=new MemberDto(todos.getMember());
    }
    @Getter
    class MemberDto{
        private Integer id;
        private String email;
        private String password;
        private String name;
        private Integer age;
        public MemberDto(Member member) {
            this.id = member.getId();
            this.email = member.getEmail();
            this.password = member.getPassword();
            this.name = member.getName();
            this.age = member.getAge();
        }
    }
}
