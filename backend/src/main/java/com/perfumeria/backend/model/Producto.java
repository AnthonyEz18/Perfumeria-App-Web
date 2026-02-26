package com.perfumeria.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String marca;
    private Double precio;
    private Integer stock;
    private String descripcion;
    private String tipo;

    public Producto() {}

    public Long getId() {return id;}
    public String getNombre() { return nombre; }
    public String getMarca() { return marca; }
    public Double getPrecio() { return precio; }
    public Integer getStock() { return stock; }
    public String getDescripcion() { return descripcion; }
    public String getTipo() { return tipo; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public void setStock(Integer stock) { this.stock = stock; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
