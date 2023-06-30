package com.naver.user.dao;


import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.RenameRequest;
import com.naver.user.domain.request.SignupRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper2 {
    User login(LoginRequest loginRequest);
    int signup(SignupRequest signupRequest);
    int changeUserInfo(RenameRequest loginRequest);
}
