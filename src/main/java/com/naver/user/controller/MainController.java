package com.naver.user.controller;


import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.ChangeRequest;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.UpdateRequest;
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
            modelAndView.addObject("todolist",bykeyword);
        }
        else {

            modelAndView.addObject("todolist", todoService.findAll());
//         투두 리스트 가져다 줘야하고

        }
        return modelAndView;
    }
    @GetMapping("/todo/todoupdate")
    public ModelAndView getUpdate(ModelAndView mav,
                                  @RequestParam (value="todoid") String id,HttpSession session)
    {
        int id2=Integer.parseInt(id) ;
        session.setAttribute("uid",id2);
        mav.setViewName("/todo/todoupdate");
        return mav;
    }
    @PostMapping("/todo/todoupdate")
    public ModelAndView postUpdate(HttpSession session,ModelAndView mav,
    @ModelAttribute ChangeRequest request)
    {
        int id = (Integer)session.getAttribute("uid");
        String name = request.getUser_id();
        String content = request.getContent();
        System.out.println(id);
        System.out.println(name);
        System.out.println(content);
        UpdateRequest req = new UpdateRequest(content,id,name);
        if(todoService.changeContent(req)==1)
        {
            mav.addObject("updatedate",req);
            mav.setViewName("redirect:/todo/main");
        }
        else {
            mav.setViewName("redirect:/todo/todoupdate");
        }
        return mav;
    }

    @PostMapping("/todo/main")
    public ModelAndView postMain(@RequestParam(value = "content") String content,
             ModelAndView mav
            , HttpSession session
    ){
        ModelAndView modelAndView = new ModelAndView();

            int id = (Integer)session.getAttribute("id");
//        content = (String)session.getAttribute("content");
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