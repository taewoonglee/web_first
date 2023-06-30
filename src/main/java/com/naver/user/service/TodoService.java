package com.naver.user.service;

import com.naver.user.dao.HeartMapper;
import com.naver.user.dao.TodoDao;
import com.naver.user.dao.TodoMapper;
import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.heart.HeartSupport;
import com.naver.user.domain.heart.IDs;
import com.naver.user.domain.heart.SetHeart;
import com.naver.user.domain.heart.TodoHeart;
import com.naver.user.domain.request.ChangeRequest;
import com.naver.user.domain.request.UpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoDao todoDao;
    private final TodoMapper todoMapper;
    private final HeartSupport heartMapper;

    public TodoService(TodoDao todoDao, TodoMapper todoMapper, HeartSupport heartMapper) {
        this.todoDao = todoDao;
        this.todoMapper = todoMapper;
        this.heartMapper = heartMapper;
    }

    public List<com.naver.user.domain.entity.TodoJoinUser> findAll(){
        return todoMapper.findAll();
    }

    public int insert(Integer uid,String content){
        //Dao 에 있는 기능을 끌어올 예정.
        return todoDao.insert(uid,content);

    }
    public List<TodoJoinUser> findByKeyword(String keyword){
        return todoMapper.findByKeyword(keyword);
    }
    public int changeContent(UpdateRequest request)
    {
        return todoMapper.changeContent(request);
    }

    public int getHeart(int tid)
    {
        return todoMapper.getHeart(tid);
    }
    public int setHeart(SetHeart setHeart)
    {
        return todoMapper.setHeart(setHeart);
    }
    public int insertHeart(IDs ids)
    {
        return todoMapper.insertHeart(ids);
    }
    public int checkHeart(IDs ids){return todoMapper.checkHeart(ids);}

    public int setTodoHeart(TodoHeart todoHeart){return todoMapper.setTodoHeart(todoHeart);}




}