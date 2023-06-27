package com.naver.user.controller;


import com.naver.user.domain.dto.TodoJoinUser;
import com.naver.user.domain.dto.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private final TodoService todoService;

    public MainController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo/main")
    public ModelAndView showMain(@RequestParam(value = "keyword",required = false) String keyword){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/todo/main");
        if(keyword!=null&& !keyword.equals(""))
        {
            List<TodoJoinUser> bykeyword = todoService.findByKeyword(keyword);
            modelAndView.addObject("todolist",keyword);
        }
        else {

            modelAndView.addObject("todolist", todoService.findAll());
//         투두 리스트 가져다 줘야하고

        }
        return modelAndView;
    }
    @PostMapping("/todo/main")
    public ModelAndView postMain(
            @ModelAttribute LoginRequest request,@RequestParam(value = "content") String content
            , ModelAndView mav
            , HttpSession session
    ){
        int id = (Integer)session.getAttribute("id");
//        content = (String)session.getAttribute("content");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("todolist",todoService.insert(id,content));
        mav.setViewName("redirect:/todo/main");

        //mav.setViewName("redirect:/main?err=not_insert
        //mav.addObject("err","not_insert");
//
//
//
//        if(id!=null && todoService.insert(id,content)!=0)
//        {
//
//        }

        return mav;
    }
}