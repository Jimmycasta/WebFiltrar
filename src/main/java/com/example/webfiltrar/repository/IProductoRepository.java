package com.example.webfiltrar.repository;

import com.example.webfiltrar.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %?1%"
            + "OR  p.marca LIKE %?1%")
    public List<Producto> findAll(String clave);
}
