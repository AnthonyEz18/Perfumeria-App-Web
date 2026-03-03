package com.perfumeria.backend.users.dto;

public record MeResponse(
    Long id,
    String email,
    String name,
    String role
) {}
