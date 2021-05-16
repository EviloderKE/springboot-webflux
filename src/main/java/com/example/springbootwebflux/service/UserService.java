package com.example.springbootwebflux.service;

import com.example.springbootwebflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getUserById(int id);

    Flux<User> getAllUsers();

    Mono<Void> addUser(Mono<User> monoUser);
}
