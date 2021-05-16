package com.example.springbootwebflux.controller;

import com.example.springbootwebflux.entity.User;
import com.example.springbootwebflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Demo {

    @Autowired
    private UserService userService;

    @GetMapping("/getById")
    public Mono<User> getById(){

        return userService.getUserById(1);
    }

    @GetMapping("/getAll")
    public Flux<User> getAll(){

        return userService.getAllUsers();
    }

    @GetMapping("/add")
    public Mono<Void> add(){
        User user = new User("dd", "male", 15);
        return userService.addUser(Mono.just(user));
    }
}
