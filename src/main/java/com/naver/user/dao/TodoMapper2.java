package com.naver.user.dao;

import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.request.UpdateRequest;

import java.util.List;

public interface TodoMapper2 {
    List<TodoJoinUser> findAll();

    List<TodoJoinUser> findByKeyword(String keyword);

    Integer changeContent(UpdateRequest request);
}
