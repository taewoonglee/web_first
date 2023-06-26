package com.naver.user.controller;

import com.naver.user.domain.dto.User;
import com.naver.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final UserService userService;
    private UserController(UserService userService)
    {
        this.userService=userService;
    }
    @GetMapping("/user/login")
    public String getLoginPage(){
        return "/user/login";
    }
    @PostMapping("/user/login")
    public ModelAndView postLogin(HttpServletRequest res, @RequestParam("id") String id
            , @RequestParam("pw") String pw, @RequestParam("idSave") boolean idSave, @ModelAttribute User user, ModelAndView mav, HttpSession session){
        System.out.println(id + "" + pw);
        System.out.println(user.getId()+ " " + user.getPw());
        System.out.println(mav.getModel());
        if(userService.login(id,pw))
        {
            session.setAttribute("id",id);
            mav.setViewName("redirect:/user/main");
        }
        else {
            mav.setViewName("redirect:/user/login");
            if(idSave)
            {

            }
        }
        mav.addObject("id",id);
        return mav;
    }
    @GetMapping("/user/signup")
    public String getSignupPage(){
        return "/user/signup";
    }
    @PostMapping("/user/signup")
    public ModelAndView postSignupPage(HttpServletRequest res, @RequestParam("id") String id
            , @RequestParam("pw") String pw, @ModelAttribute User user, ModelAndView mav)
    {
        if(userService.signup(id, pw))
        {
            mav.setViewName("redirect:/user/login");

        }
        else {
            mav.setViewName("redirect:/user/signup");
        }



        return mav;
    }



}
