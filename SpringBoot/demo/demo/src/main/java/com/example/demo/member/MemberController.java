package com.example.demo.member;
import com.example.demo.User;
import com.example.demo.hobby.Hobby;
import com.example.demo.hobby.HobbyResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.store.Store.members;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping
    public List<MemberResponse> findAll(){
        return memberService.findAll();
    }
    @GetMapping("{id}")
    public Member findById(@PathVariable("id") Integer id){

        return memberService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MemberRequest member){

            memberService.save(member.toEntity());
//            return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @PutMapping("{id}")
    public Member put(@PathVariable("id") Integer id ,@RequestBody MemberRequest request)
    {
        return memberService.put(id,request);

    }
    @DeleteMapping("{id}")
    public List<Member> delete(@PathVariable("id") Integer id)
    {   List<Member> memlist;
        memlist = memberService.delete(id);
        return memlist;
    }

}
