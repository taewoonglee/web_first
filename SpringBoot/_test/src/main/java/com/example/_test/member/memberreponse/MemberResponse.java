package com.example._test.member.memberreponse;

import com.example._test.member.domain.entity.Member;
import com.example._test.todos.domain.entity.Todos;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberResponse {
    private Integer id;
    private String email;
    private String password;
    private String name;
    private Integer age;
    private List<TodoDto> todos;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.name = member.getName();
        this.age = member.getAge();
        this.todos = member.getTodosList().stream().map(TodoDto::new).toList();
//        this.todos = member.getTodosList().stream().map(h->new TodoDto()).toList() :new ArrayList<>();




    }
    @Getter
    @AllArgsConstructor
    class TodoDto{
        private Integer id;
        private String title;
        private String content;
        private Boolean isDone;
        private Integer likeCount;
        public TodoDto(Todos todos)
        {
            this.id=todos.getId();
            this.content=todos.getContent();
            this.isDone=todos.getIsDone();
            this.title=todos.getTitle();
            this.likeCount= todos.getLikeCount();
        }

    }
}
