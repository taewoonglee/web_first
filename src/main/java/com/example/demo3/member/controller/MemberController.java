package com.example.demo3.member.controller;


import com.example.demo3.hobby.domain.entity.Member;
import com.example.demo3.hobby.domain.entity.MemberHobby;
import com.example.demo3.hobby.domain.request.HobbyRequest;
import com.example.demo3.hobby.domain.request.MemberRequest;
import com.example.demo3.hobby.domain.request.WordRequest;
import com.example.demo3.hobby.response.MemberResponse;
import com.example.demo3.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;
//    @GetMapping
//    public List<Member> findAllMember()
//    {
//        return memberService.findAllMember();
//    }
//    @GetMapping
//    public List<MemberResponse> findAll()
//    {
//        return memberService.findAll();
//    }
    @GetMapping
    public List<MemberResponse> findAll(@RequestParam (name ="name",required = false,defaultValue = "") String name)
    {
        return memberService.findAll(name);
    }

    @GetMapping("{id}")
    public MemberResponse findMember(@PathVariable("id") Long id)
    {
        return memberService.findById(id);
    }
    @PostMapping
    public void postMember(@RequestBody MemberRequest request)
    {
        memberService.save(request);
    }
    @DeleteMapping("{id}")
    public List<Member> deleteMember(@PathVariable("id") Long id)
    {
        List<Member> memli;
        memli=memberService.deleteIdMember(id);
        return memli;
    }
    @PutMapping("{id}")
    public List<Member> updateMember(@PathVariable("id") Long id, @RequestBody MemberRequest request)
    {
        return memberService.updateMember(id,request);
    }
    @PostMapping("/find")
    public List<Member> selectNameMember(@RequestBody WordRequest request)
    {
        return memberService.selectNameByMember(request);
    }
    @GetMapping("/connect")
    public List<MemberHobby> connectMemberHobby()
    {

        return memberService.connectMemberHobby();
    }
//    @GetMapping("/memberhobby")
//    public List<MemberHobby> allMembetHobby()
//    {
//        return memberService.allMemberHobby();
//    }


}
