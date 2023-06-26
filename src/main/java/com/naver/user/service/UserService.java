package com.naver.user.service;

public interface UserService {

    boolean login(String id, String pw);
    boolean signup(String id, String pw);

}
