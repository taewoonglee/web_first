package com.example.demo3.hobby.controller;


import com.example.demo3.hobby.domain.entity.Hobby;
import com.example.demo3.hobby.domain.request.HobbyRequest;
import com.example.demo3.hobby.response.HobbyResponse;
import com.example.demo3.hobby.response.MemberResponse;
import com.example.demo3.hobby.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hobbies")
public class HobbyController {
    private final HobbyService service;
//    @PostMapping
//    public void save(@RequestBody Map<String , String>map){
//        service.save(map.get("name"));
//    }
    @PostMapping
    public void save(@RequestBody HobbyRequest request){
        service.save(request);
    }
    @GetMapping("{id}")
    public Hobby findById(@PathVariable("id") Long id)
    {
        return service.find(id);
    }
    @GetMapping
    public List<HobbyResponse> findAllHobby()
    {
        return service.findAll();
    }
    @DeleteMapping("{id}")
    public void deleteHobby(@PathVariable Long id){
        service.deleteHobby(id);
    }
    @PutMapping("{id}")
    public void updateHobby(@PathVariable Long id, @RequestBody HobbyRequest request)
    {
        service.updateHobby(id,request);
    }
//    @GetMapping
//    public List<MemberResponse> getAll(@RequestParam(name="name",required = false,defaultValue = "") String name){
//        return service.findAll(name);
//    }
}
