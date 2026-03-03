package com.perfumeria.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import com.perfumeria.backend.users.dto.MeResponse;
import com.perfumeria.backend.users.entity.User;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class UsersController {

    @GetMapping("/me")
    public MeResponse me(){
    var auth = SecurityContextHolder.getContext().getAuthentication();
    User user = (User) auth.getPrincipal();

    return new MeResponse(
        user.getId(),
        user.getEmail(),
        user.getName(),
        user.getRole()
        );
    }

    @GetMapping("/test")
    public String test() {
        return "Backend funcionando";
    }
    

}
