package com.xk.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by hengxiaokang
 * Date:2018/9/19
 * Time:14:56
 */
@RestController
@RequestMapping("/")
public class HelloController
{
    @GetMapping("/hello")
    public Mono<String> hello()
    {
        return Mono.just("Welcome to reactive world ~");
    }
}