package com.naver.user.service;

import com.naver.user.dao.UserDao;
import com.naver.user.dao.UserMapper;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

//    public User login(LoginRequest request) {
//        try {
//            return userDao.login(request.getId(), request.getPassword());
//        }catch (Exception e){
//            return null;
//        }
//
//    }

    @Override
    public User login(LoginRequest request) {
        return userMapper.login(request);
    }

    @Override
    public Integer signup(SignupRequest request) {
        return userMapper.signup(request);
    }

//    @Override
//    public boolean signup(SignupRequest request) {
//        return userDao.signup(request) != 0;
//    }
}