package com.naver.user.dao;

import com.naver.user.domain.dto.Todo;
import com.naver.user.domain.dto.TodoJoinUser;
import com.naver.user.domain.dto.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//public class TodoRowMapper implements RowMapper<TodoJoinUser> {
//
//
//
//    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Todo todo = new Todo();
//        todo.setId(rs.getInt("id"));
//        todo.setUsername(rs.getString("username"));
//        todo.setName(rs.getString("name"));
//        return todo;
//    }
//}
