package com.perfumeria.backend.catalog.dto;

public record CatalogProductResponse(
    Long id,
    String nombre,
    String marca,
    Double precio,
    Integer stock,
    String descripcion,
    String tipo
) {}
