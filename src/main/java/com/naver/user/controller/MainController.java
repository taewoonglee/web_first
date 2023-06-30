package com.naver.user.controller;


import com.naver.user.domain.entity.TodoJoinUser;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.heart.IDs;
import com.naver.user.domain.heart.SetHeart;
import com.naver.user.domain.heart.TodoHeart;
import com.naver.user.domain.request.*;
import com.naver.user.service.TodoService;
import com.naver.user.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    private final TodoService todoService;
    private final UserServiceImpl userService;

    public MainController(TodoService todoService, UserServiceImpl userService) {
        this.todoService = todoService;
        this.userService = userService;
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
        mav.addObject("todoid",id);
//        int id2=Integer.parseInt(id) ;
//        session.setAttribute("uid",id2);
        mav.setViewName("/todo/todoupdate"); //무엇을 보여주는지
        return mav;
    }
    @PostMapping("/todo/todoupdate")
    public ModelAndView postUpdate(HttpSession session,ModelAndView mav,
    @ModelAttribute ChangeRequest request)
    {
        int id = (Integer)session.getAttribute("id");
        int uid = request.getUser_id();
        String content = request.getContent();
        UpdateRequest req = new UpdateRequest(content,id,uid);
        if(todoService.changeContent(req)==1)
        {
            mav.addObject("update",req);
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
    } @GetMapping("/user/change")
    public ModelAndView getChangeUserInfo(ModelAndView mav)
    {
        mav.setViewName("/user/change");
        return mav;
    }
    @PostMapping("/user/change")
    public ModelAndView postChangeUserInfo(ModelAndView mav,
                                           @ModelAttribute GetRequest request, HttpSession session)
    {
        int id = (Integer)session.getAttribute("id");
        String username = request.getUsername();
        String password = request.getPassword();
        RenameRequest req = new RenameRequest(username,password,id);
//        System.out.println(id);
//        System.out.println(username);
//        System.out.println(password);
//        mav.addObject("change", service.changeUserInfo(req));
//        mav.setViewName("redirect:/todo/main");
        if(userService.changeUserInfo(req)==1)
        {
            mav.setViewName("redirect:/todo/main");
        }
        else {
            mav.setViewName("redirect:/todo/main");
        };
        return mav;
    }
//    @GetMapping("/todo/like")
//    public ModelAndView getLike(ModelAndView mav,
//                                  @RequestParam ("todoid") Integer id, HttpSession session)
//    {
//        Integer tid = id;
//        session.setAttribute("tid",tid);
//        mav.setViewName("/todo/like");
//        return mav;
//    }
    @PostMapping("/todo/like")
    public ModelAndView postLike(HttpSession session,ModelAndView mav)
    {
        int uid = (Integer)session.getAttribute("id");
        int tid = (Integer)session.getAttribute("tid");
        System.out.println(uid);
        System.out.println(tid);
        IDs ids=new IDs(uid,tid);
        if(todoService.checkHeart(ids)==1)
        {
            SetHeart setHeart = new SetHeart(tid,0);
            TodoHeart todoHeart = new TodoHeart(tid,-1);
            // heart가 1이므로 0으로 set 해줌
            todoService.setHeart(setHeart);
            todoService.setTodoHeart(todoHeart);

        }
        else {
            todoService.insertHeart(ids);
            SetHeart setHeart = new SetHeart(tid,1);
            TodoHeart todoHeart = new TodoHeart(tid,1);
            //heart 0이므로 1로 set 해줌
            todoService.setHeart(setHeart);
            todoService.setTodoHeart(todoHeart);

        }
        if(todoService.getHeart(tid)==1)
        {

            mav.setViewName("/todo/like"); //무엇을 보여주는지
        }
        else {

            mav.setViewName("/todo/like"); //무엇을 보여주는지
        }
        mav.setViewName("redirect:/todo/main");
        return mav;
    }
}