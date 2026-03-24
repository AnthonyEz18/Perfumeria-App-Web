package com.perfumeria.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfumeria.backend.catalog.dto.CatalogProductResponse;
import com.perfumeria.backend.model.Producto;
import com.perfumeria.backend.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final ProductoRepository productoRepository;
    
    @GetMapping("/products")
    public List<CatalogProductResponse> listProducts() {
        return productoRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<CatalogProductResponse> getProductById(@PathVariable Long id) {
        return productoRepository.findById(id)
            .map(this::toResponse)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private CatalogProductResponse toResponse(Producto producto) {
        return new CatalogProductResponse(
            producto.getId(),
            producto.getNombre(),
            producto.getMarca(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getDescripcion(),
            producto.getTipo()
        );
    }
}
