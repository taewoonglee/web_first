package com.naver.user.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;


    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public Integer login(String id, String pw){
        String sql = "select id from users where username = ? and password = ?";

        return jdbcTemplate.queryForObject(sql,Integer.class,id,pw);
    }
    public Integer signup(String id, String pw,String name)
    {
        String sql = "insert into users(username,password,name) values(?,?,?)";
        return jdbcTemplate.update(sql,id,pw,name);
    }
}
