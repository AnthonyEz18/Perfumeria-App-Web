package com.perfumeria.backend.repository;

import com.perfumeria.backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
