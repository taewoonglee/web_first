package com.naver.user.dao;

import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserMapper {
    private final SqlSessionTemplate sessionTemplate;

    public UserMapper(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
    public User login(LoginRequest loginRequest){
        return sessionTemplate.selectOne("user.login",loginRequest);
    }
}
