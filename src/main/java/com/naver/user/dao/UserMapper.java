package com.naver.user.dao;

import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignupRequest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {
    private final SqlSessionTemplate sessionTemplate;

    public UserMapper(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
    public User login(LoginRequest loginRequest){
        return sessionTemplate.selectOne("user.login",loginRequest);
    }
    public int signup(SignupRequest signupRequest)
    {
        return(sessionTemplate.insert("user.signup",signupRequest));
    }
}
