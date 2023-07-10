package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("users")
public class DemoController {
    List<User> userList = new ArrayList<>();

    public DemoController() {
        userList.add(new User("김수동",29));
        userList.add(new User("이세인",25));
        userList.add(new User("이태웅",26));
        userList.add(new User("정민균",28));
    }

    @GetMapping
    public List<User> test() throws InterruptedException

    {
        return userList;
    }
    @GetMapping("{name}")

    public User findByName(@PathVariable("name") String name)
    {
        return userList.stream().filter(u->u.getName().equals(name))
                .findFirst().orElse(null);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody User user)
    {
//        userList.add(user);
        // 만약 user가 있을 때는 200
        // 없으면 201

        User user1 = userList.stream().filter(u->u.getName().equals(user.getName()))
                .findFirst().orElse(null);
        if(user1==null)
        {
            userList.add(user);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    @DeleteMapping("{name}")
    public void delete(@PathVariable("name") String name)
    {
        userList=
        userList.stream().filter(u-> u.getName().equals(name)).toList();
    }
    @PutMapping("{name}")
    public void update(@PathVariable String name,@RequestBody User user){
        userList = userList.stream().map(u-> u.getName().equals(name)? user : u).toList();
    }

}
