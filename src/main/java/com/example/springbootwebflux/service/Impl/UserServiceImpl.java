package com.example.springbootwebflux.service.Impl;

import com.example.springbootwebflux.entity.User;
import com.example.springbootwebflux.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> users= new HashMap<>();


    public UserServiceImpl(){
        users.put(1, new User("aa", "male", 10));

        users.put(2, new User("bb", "female", 11));

        users.put(3, new User("cc", "male", 12));
    }


    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(users.get(id));
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(users.values());
    }

    @Override
    public Mono<Void> addUser(Mono<User> monoUser) {
        return monoUser.doOnNext(i -> {
            int id = users.size() + 1;
            users.put(id, i);
        }).thenEmpty(Mono.empty());
    }
}
