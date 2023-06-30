package com.naver.user.service;

import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.RenameRequest;
import com.naver.user.domain.request.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User login(LoginRequest request);
    Integer signup(SignupRequest request);


    Integer changeUserInfo(RenameRequest request);
}