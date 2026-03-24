package com.perfumeria.backend.auth;
import com.perfumeria.backend.users.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.perfumeria.backend.auth.dto.LoginRequest;
import com.perfumeria.backend.auth.dto.RegisterRequest;
import com.perfumeria.backend.auth.jwt.JwtService;
import com.perfumeria.backend.users.entity.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public void register(RegisterRequest req){

        if(userRepository.findByEmail(req.email()).isPresent()){
            throw new RuntimeException("Email ya registrado");
        }

        User user = new User();
        user.setEmail(req.email());
        user.setName(req.name());
        user.setPassword(passwordEncoder.encode(req.password()));
        String requestedRole = req.role() == null ? "" : req.role().trim();
        user.setRole(requestedRole.isEmpty() ? "USER" : requestedRole.toUpperCase());

        userRepository.save(user);
    }

    public String login(LoginRequest req){
        User user = userRepository.findByEmail(req.email())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

                System.out.println("LOGIN EMAIL: " + req.email());
        if(!passwordEncoder.matches(req.password(), user.getPassword())){
            throw new RuntimeException("Credenciales inválidas");
        }
        System.out.println("USER DB: " + user.getEmail());
        System.out.println("PASSWORD MATCH: " + passwordEncoder.matches(req.password(), user.getPassword()));

        return jwtService.generateToken(user);
    }

}
