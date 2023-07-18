package com.example._test.todos.domain.request;

import com.example._test.member.domain.entity.Member;
import com.example._test.todos.domain.entity.Todos;
import lombok.Getter;

@Getter
public class TodosRequest {
    private String title;
    private String content;
    private Integer memberId;
    private Integer likecount;
    private Boolean isDone;
    public Todos toEntity(){
        return Todos.builder().title(title).
                content(content).likeCount(0).isDone(false).
                member(Member.builder().id(memberId).build()).build();
    }
}
