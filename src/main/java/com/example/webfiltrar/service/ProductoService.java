package com.example.webfiltrar.service;

import com.example.webfiltrar.entities.Producto;
import com.example.webfiltrar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository repository;

    public void save(Producto producto) {
        repository.save(producto);
    }

    public List<Producto> listAll(String clave) {
        if (clave != null){
            return repository.findAll(clave);

        }
        return repository.findAll();
    }

    public Producto getById(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}



