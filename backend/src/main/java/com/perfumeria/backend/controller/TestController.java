package com.perfumeria.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import com.perfumeria.backend.users.entity.User;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/me")
    public User me(){
    var auth = SecurityContextHolder.getContext().getAuthentication();
    return (User) auth.getPrincipal();
    }

    @GetMapping("/test")
    public String test() {
        return "Backend funcionando";
    }
    

}
