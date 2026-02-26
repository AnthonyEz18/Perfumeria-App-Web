package com.perfumeria.backend.auth.dto;

public record RegisterRequest (
    String email,
    String password,
    String name
){}
