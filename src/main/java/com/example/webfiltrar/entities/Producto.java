package com.example.webfiltrar.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    @Column(name = "marca", nullable = false, length = 60)
    private String marca;
    @Column(name = "hecho", nullable = false, length = 60)
    private String hecho;
    @Column(name = "precio", nullable = false, length = 60)
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, String marca, String hecho, double precio) {
        this.nombre = nombre;
        this.marca = marca;
        this.hecho = hecho;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getHecho() {
        return hecho;
    }

    public void setHecho(String hecho) {
        this.hecho = hecho;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", hecho='" + hecho + '\'' +
                ", precio=" + precio +
                '}';
    }
}
