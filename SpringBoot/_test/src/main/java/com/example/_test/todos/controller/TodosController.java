package com.example._test.todos.controller;


import com.example._test.like.domain.request.LikeRequest;
import com.example._test.todos.domain.entity.Todos;
import com.example._test.todos.domain.request.CheckRequest;
import com.example._test.todos.domain.request.TodosRequest;
import com.example._test.todos.response.TodosResponse;
import com.example._test.todos.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todos")
public class TodosController {
    private final TodoService todoService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insertTodos(@RequestBody TodosRequest request)
    {
        todoService.insertTodos(request);
    }
    @GetMapping("{content}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Todos> findByName(@PathVariable("content") String content, @RequestParam (name ="size",required = false,defaultValue = "20")Integer size,
                                  @RequestParam (name="page",required = false,defaultValue = "0")Integer page)
    {
        PageRequest request=PageRequest.of(page,size);
        return todoService.findByContent(content,request);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TodosResponse> findAll(@RequestParam (name ="size",required = false,defaultValue = "20")Integer size,
                                       @RequestParam(name="page",required = false,defaultValue = "0")Integer page)
    {
        PageRequest pageRequest = PageRequest.of(page,size);
        return todoService.findAllTodos(pageRequest);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putById(@PathVariable("id") Integer id, @RequestBody TodosRequest request)
    {
        todoService.changeById(id,request);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable("id") Integer id)
    {
        todoService.deleteById(id);
    }
//    @PostMapping("/check")
//    public Boolean checkLikeById(@RequestBody LikeRequest request)
//    {
//        return todoService.checkById(request);
//    }
    @PostMapping("/like")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean likeById(@RequestBody LikeRequest request)
    {
        return todoService.likeById(request);
    }

    @PostMapping("/check")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean checkLikeById(@RequestBody CheckRequest request)
    {
        return todoService.checkList(request);
    }

}
