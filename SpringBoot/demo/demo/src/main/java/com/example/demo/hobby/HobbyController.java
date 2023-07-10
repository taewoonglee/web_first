package com.example.demo.hobby;


import com.example.demo.store.Store;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/hobby")

public class HobbyController {
    private final HobbyService service;
    @GetMapping()
    public List<Hobby> getHobby()

    {
        return service.findHobby();
    }
    @GetMapping("{id}")
    public Hobby findByIdHobby(@PathVariable ("id") Integer id)
    {
        return service.findHobbyById(id);
    }
    @PostMapping
    public void postHobby(@RequestBody HobbyInsert request)
    {
        service.addHobby(request);
    }

    @DeleteMapping("{id}")
    public void deleteHobby(@PathVariable ("id") Integer id)
    {
        service.deleteHobby(id);

    }
    @PutMapping("{id}")
    public void putHobby(@PathVariable ("id") Integer id, @RequestBody HobbyRequest request)
    {
        service.changeHobbyById(id,request);
    }






}
