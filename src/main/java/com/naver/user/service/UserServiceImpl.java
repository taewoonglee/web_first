package com.naver.user.service;


import com.naver.user.dao.UserDao;
import com.naver.user.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    List<User> users = new ArrayList<>();


    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(String id, String pw) {
        Integer logined = userDao.login(id,pw);
        if(logined==null)
        {
            return false;
        }
        return true;
//        for(int i=0;i<users.size();i++)
//        {
//            if(users.get(i).getId().equals(id)&& users.get(i).getPw().equals(pw))
//
//                return true;
//        }
//        return false;
    }

    @Override
    public boolean signup(String id, String pw, String name) {
        Integer check=userDao.signup(id,pw,name);
        if(check==null)
        {
            return false;
        }
        return true;
//        if(id.equals("")||pw.equals(""))
//        {
//            return false;
//        }
//        for(int i=0;i< users.size();i++)
//        {
//            if(users.get(i).getId().equals(id))
//            {
//                return false;
//            }
//        }
//        users.add(new User(id,pw));
//        return true;
    }
}
