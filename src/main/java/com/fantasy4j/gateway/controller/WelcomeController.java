package com.fantasy4j.gateway.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by lihui23 on 2019/11/25
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/hello")
    public String fix(@RequestParam("content") String content) {

        return "hello " + content;
    }
}
