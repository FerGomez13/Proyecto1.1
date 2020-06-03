package com.uabc.edu.examen.web;

import com.uabc.edu.examen.exception.RecordNotFoundException;
import com.uabc.edu.examen.model.AnimalesEntity;
import com.uabc.edu.examen.model.ProductosEntity;
import com.uabc.edu.examen.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductosMvcController {

    @Autowired
    private ProductosService service;

    @RequestMapping("/principal")
    public String principal() {
        return "principal";
    }

    @RequestMapping("/infoProductos")
    public String getProducts(Model model) //Consulta General
    {
        List<ProductosEntity> product = service.getProducts();

        model.addAttribute("product", product);
        return "consultaProductos";
    }

    @RequestMapping("/compra")
    public String getProdutsAdop(Model model) //Consulta
    {
        List<ProductosEntity> product = service.getProducts();

        model.addAttribute("product", product);
        return "consultaAProductos";
    }

    @RequestMapping("/modificarProductos")
    public String getProductsM(Model model) //Consulta General
    {
        List<ProductosEntity> product = service.getProducts();

        model.addAttribute("product", product);
        return "consultaMProductos";
    }
    
    @RequestMapping("/InicioProductos")
    public String inicio(Model model) {
        model.addAttribute("product", new ProductosEntity());
        return "createProductos";
    }

    @RequestMapping("/editProductos")
    public String update() {
        return "modificarProductos";
    }

    @RequestMapping(path = {"/editarProductos/{id}"})
    public String editProductosById(Model model, @PathVariable(value = "id", required = true) Long id) {
        ProductosEntity product = service.getProductById(id);
        model.addAttribute("product", product);
        return "modificarProductos";
    }

    @RequestMapping(path = {"/adoptProductos/{id}"})
    public String editProductosByIdA(Model model, @PathVariable(value = "id", required = true) Long id) {
        ProductosEntity product = service.getProductById(id);
        model.addAttribute("product", product);
        return "comprarProductos";
    }

    @RequestMapping(path = {"/deleteProductos", "/deleteProductos/{id}"})
    public String deleteProductosById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteProductosById(id);
        return "redirect:/infoProductos";
    }

    @RequestMapping(path = "/createProduct", method = RequestMethod.POST)
    public String createProduct(@RequestParam(value = "id", required = false) Optional<Long> id,
                                @RequestParam(value = "producto", required = true) String producto,
                                @RequestParam(value = "precio", required = true) int precio,
                                @RequestParam(value = "cantidad", required = true) int cantidad,
                                @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {
        ProductosEntity productEntity;
        if (id.isPresent()) {
            productEntity = service.getProductById(id.get());
        } else {
            productEntity = new ProductosEntity(); //empty entity
        }
        productEntity.setProducto(producto);
        productEntity.setPrecio(precio);
        productEntity.setCantidad(cantidad);
        try {
            productEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        productEntity.setStr(Base64.getEncoder().encodeToString(productEntity.getFoto()));
        service.createProduct(productEntity);
        return "redirect:/infoProductos";
    }

    @RequestMapping(path = "/updateProduct", method = RequestMethod.POST)
    public String updateAnimal(@RequestParam(value = "id", required = false) Optional<Long> id,
                               @RequestParam(value = "producto", required = true) String producto,
                               @RequestParam(value = "precio", required = true) int precio,
                               @RequestParam(value = "cantidad", required = true) int cantidad,
                               @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {
        ProductosEntity productEntity;
        if (id.isPresent()) {
            productEntity = service.getProductById(id.get());
        } else {
            productEntity = new ProductosEntity();
        }
        productEntity.setProducto(producto);
        productEntity.setPrecio(precio);
        productEntity.setCantidad(cantidad);
        try {
            productEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        productEntity.setStr(Base64.getEncoder().encodeToString(productEntity.getFoto()));
        service.createProduct(productEntity);
        return "redirect:/infoProductos";
    }

    @RequestMapping("/eliminarProductos")
    public String getProductsBajas(Model model) //Consulta
    {
        List<ProductosEntity> product = service.getProducts();

        model.addAttribute("product", product);
        return "eliminarProductos";
    }

    @RequestMapping("/adoptarProductos")
    public String getProductsAdop(Model model) //Consulta
    {
        List<ProductosEntity> product = service.getProducts();

        model.addAttribute("product", product);
        return "consultaAProductos";
    }

    @RequestMapping(path = "/adoptateProduct", method = RequestMethod.POST)
    public String adoptateProduct(@RequestParam(value = "id", required = false) Optional<Long> id,
                                  @RequestParam(value = "producto", required = true) String producto,
                                  @RequestParam(value = "precio", required = true) int precio,
                                  @RequestParam(value = "cantidad", required = true) int cantidad,
                                  @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {
        ProductosEntity productEntity;
        if (id.isPresent()) {
            productEntity = service.getProductById(id.get());
        } else {
            productEntity = new ProductosEntity();
        }
        productEntity.setProducto(producto);
        productEntity.setPrecio(precio);
        productEntity.setCantidad(cantidad);
        try {
            productEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        productEntity.setStr(Base64.getEncoder().encodeToString(productEntity.getFoto()));
        service.createProduct(productEntity);
        return "redirect:/infoProductos";
    }
}
