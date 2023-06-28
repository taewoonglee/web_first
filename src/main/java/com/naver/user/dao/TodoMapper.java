package com.naver.user.dao;
import com.naver.user.domain.entity.TodoJoinUser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoMapper {
    private final SqlSessionTemplate sessionTemplate;

    public TodoMapper(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public List<TodoJoinUser> findAll(){
        return sessionTemplate.selectList("todo.findAll");
    }
}
