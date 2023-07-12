package com.example.demo3.hobby.controller;


import com.example.demo3.hobby.domain.entity.Hobby;
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
    public void save(@RequestBody Map<String, String> map){
        service.save(map.get("name"));
    }
    @GetMapping("{id}")
    public Hobby findById(@PathVariable("id") Long id)
    {
        return service.find(id);
    }
    @GetMapping
    public List<Hobby> findAllHobby()
    {
        return service.findAllHobby();
    }
}
