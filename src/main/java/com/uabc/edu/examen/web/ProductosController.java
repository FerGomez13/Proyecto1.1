package com.uabc.edu.examen.web;

import com.uabc.edu.examen.model.ProductosEntity;
import com.uabc.edu.examen.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequestMapping("/comprar")
public class ProductosController {

    @Autowired
    private ProductosService service;

    @RequestMapping(path = {"/comprarProductos/{id}"})
    public String editProductosByIdA(Model model, @PathVariable(value = "id", required = true) Long id) {
        ProductosEntity product = service.getProductById(id);
        model.addAttribute("product", product);
        return "comprarProductos";
    }

    @RequestMapping(path = "/comprateProductos", method = RequestMethod.POST)
    public String adoptateAnimal(@RequestParam(value = "id", required = false) Optional<Long> id,
                                 @RequestParam(value = "producto", required = true) String producto,
                                 @RequestParam(value = "precio", required = true) int precio,
                                 @RequestParam(value = "cantidad", required = true) int cantidad,
                                 @RequestParam(value = "foto", required = false) MultipartFile foto) {
        ProductosEntity productosEntity;
        if (id.isPresent()) {
            productosEntity = service.getProductById(id.get());
        } else {
            productosEntity = new ProductosEntity();
        }
        System.out.println(productosEntity.toString());
        productosEntity.setProducto(producto);
        productosEntity.setPrecio(precio);
        productosEntity.setCantidad(cantidad);
        productosEntity.setFoto(productosEntity.getFoto());
        productosEntity.setStr(productosEntity.getStr());
        System.out.println(productosEntity.getId() + "hola mi amigo");
        service.createProduct(productosEntity);

        return "redirect:/compra";
    }
}
