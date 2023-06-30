package com.naver.user.dao;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.heart.IDs;
import com.naver.user.domain.heart.SetHeart;
import com.naver.user.domain.heart.TodoHeart;
import com.naver.user.domain.request.ChangeRequest;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.UpdateRequest;
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

    public List<TodoJoinUser>   findByKeyword(String keyword){
        return sessionTemplate.selectList("todo.findByKeyword","%"+keyword+"%");
    }
    public Integer changeContent(UpdateRequest request)
    {
        return sessionTemplate.update("todo.changeContent",request);
    }
    public Integer insertHeart(IDs iDs)
    {
        return sessionTemplate.insert("todo.insertHeart",iDs);
    }
    public Integer getHeart(int tid)
    {
        return sessionTemplate.selectOne("todo.getHeart",tid);
    }
    public Integer setHeart(SetHeart setHeart)

    {
        return sessionTemplate.selectOne("todo.setHeart",setHeart);
    }
    public Integer checkHeart(IDs iDs){return sessionTemplate.selectOne("todo.checkHeart",iDs);}

    public Integer setTodoHeart(TodoHeart todoHeart){return sessionTemplate.update("todo.setTodoHeart",todoHeart);}


}
