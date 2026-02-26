package com.perfumeria.backend.auth.dto;

public record LoginRequest(
    String email,
    String password
) {}
