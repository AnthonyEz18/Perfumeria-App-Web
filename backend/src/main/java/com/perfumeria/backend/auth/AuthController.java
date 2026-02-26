package com.perfumeria.backend.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfumeria.backend.auth.dto.LoginRequest;
import com.perfumeria.backend.auth.dto.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req){
        authService.register(req);
        return ResponseEntity.ok("Usuario creado");
    }

    @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody LoginRequest req){
        String token = authService.login(req);
        return ResponseEntity.ok(java.util.Map.of("token", token));
   }
    
}
