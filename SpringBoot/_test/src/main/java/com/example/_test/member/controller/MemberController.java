package com.example._test.member.controller;


import com.example._test.member.domain.entity.Member;
import com.example._test.member.domain.request.LoginRequest;
import com.example._test.member.domain.request.MemberRequest;
import com.example._test.member.domain.entity.MemberTodos;
import com.example._test.member.memberreponse.MemberResponse;
import com.example._test.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/members")
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/signup")
    public void insertMember(@RequestBody MemberRequest member)
    {
        memberService.signupMember(member);
    }
    @PostMapping("/login")
    public Boolean loginMember(@RequestBody LoginRequest request)
    {
        return memberService.loginMember(request);
    }
    @GetMapping()
    public List<MemberResponse> allTodos(@RequestParam (name="size",required = false,defaultValue = "10")Integer size
                                    , @RequestParam (name = "page",required = false,defaultValue = "0")Integer page)
    {
        PageRequest pageRequest = PageRequest.of(page,size);
        return memberService.findAll(pageRequest);
    }


//    @GetMapping()
//    public Page<MemberTodos> allMembers(@RequestParam (name="size",required = false,defaultValue = "10")Integer size
//            , @RequestParam (name = "page",required = false,defaultValue = "0")Integer page)
//    {
//        PageRequest pageRequest = PageRequest.of(page,size);
//        return memberService.allMembers(pageRequest);
//    }

}
