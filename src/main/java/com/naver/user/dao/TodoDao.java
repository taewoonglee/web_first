package com.naver.user.dao;

import com.naver.user.domain.entity.TodoJoinUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDao {
    private final JdbcTemplate jdbcTemplate;
    public TodoDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<TodoJoinUser> findAll(){
        String sql = "select\n" +
                "    t.id,\n" +
                "    t.create_at ,\n" +
                "    t.content,\n" +
                "    t.checked,\n" +
                "    u.name,\n" +
                "    u.id uid\n" +
                "from todos.todos as t\n" +
                "inner join todos.users as u\n" +
                "    on t.user_id = u.id";
        List<TodoJoinUser> todoJoinUsers;
        todoJoinUsers = jdbcTemplate.query(sql, getTodoJoinUserRowMapper());

        return todoJoinUsers;
    }

    private RowMapper<TodoJoinUser> getTodoJoinUserRowMapper() {
        return (rs, rowNum) ->
                new TodoJoinUser(
                        rs.getInt("id"),
                        rs.getString("content"),
                        rs.getString("create_at"),
                        rs.getBoolean("checked"),
                        rs.getString("name"),
                        rs.getInt("uid"),
                        null
                );
    }
    public Integer insert(int uid,  String content)
    {
        int checked=0;
        String sql = "insert into todos(user_id, content,checked) values (?,?,?)";
        return jdbcTemplate.update(sql
                , uid,  content,checked);

    }
    public List<TodoJoinUser> findKeyword(String keyword){
        if(keyword!=null&& !keyword.equals(""))
        {

        }
        String sql = "select\n" +
                "    t.id,\n" +
                "    t.create_at ,\n" +
                "    t.content,\n" +
                "    t.checked,\n" +
                "    u.name,\n" +
                "    u.id uid\n" +
                "from todos.todos as t\n" +
                "inner join todos.users as u\n" +
                "    on t.user_id = u.id" +
                "where content like ?";
        List<TodoJoinUser> todoJoinUsers;
        todoJoinUsers = jdbcTemplate.query(sql, getTodoJoinUserRowMapper(),"%" + keyword +"%");

        return todoJoinUsers;
    }

}
