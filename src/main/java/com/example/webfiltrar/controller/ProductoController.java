package com.example.webfiltrar.controller;

import com.example.webfiltrar.entities.Producto;
import com.example.webfiltrar.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService service;

    @RequestMapping("/")
    public String inicio(Model model, @Param("clave") String clave) {
        List<Producto> listarProducto = service.listAll(clave);
        model.addAttribute("listarProducto",listarProducto );
        model.addAttribute("clave", clave);
        return "index";

    }
    @RequestMapping("/agregar")
    public String agregarProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "agregar";
    }
    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    public String guardarProducto(@ModelAttribute("producto") Producto producto){
        service.save(producto);
        return "redirect:/";
    }
    @RequestMapping("/editar/{id}")
    public ModelAndView editarProducto (@PathVariable(name = "id") Long id){
        ModelAndView model = new ModelAndView("editar");
        Producto producto = service.getById(id);
        model.addObject("producto",producto);
        return model;

    }
    @RequestMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable (name = "id") Long id){
        service.delete(id);
        return "redirect:/";

    }

}
