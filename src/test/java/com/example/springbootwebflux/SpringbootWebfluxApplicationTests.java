package com.example.springbootwebflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringbootWebfluxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void demo1(){
        //Flux.just(1, 2, 3, 4).subscribe(System.out::println);

        //Mono.just(1);

        //Flux.just(1, 2).map(i -> i * i).subscribe(System.out::println);


        Flux.just(1, 2).flatMap(i -> Mono.just(8)).subscribe(System.out::println);
    }

}
