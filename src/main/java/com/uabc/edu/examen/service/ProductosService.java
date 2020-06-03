package com.uabc.edu.examen.service;

import com.uabc.edu.examen.exception.RecordNotFoundException;
import com.uabc.edu.examen.model.ProductosEntity;
import com.uabc.edu.examen.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    ProductosRepository repository;

    public List<ProductosEntity> getProducts() {
        return (List<ProductosEntity>) repository.findAll();
    }

    public ProductosEntity getProductById(Long id) {
        Optional<ProductosEntity> product = repository.findById(id);

        if (product.isPresent()) {
            return repository.findById(id).get();
        }
        return product.get();
    }

    public ProductosEntity createProduct(ProductosEntity pro) {
        if (pro.getId() == null) {
            pro = repository.save(pro);

            return pro;
        } else {
            Optional<ProductosEntity> product = repository.findById(pro.getId());
            if (product.isPresent()) {
                ProductosEntity newProduct = product.get();
                newProduct.setId(pro.getId());
                newProduct.setProducto(pro.getProducto());
                newProduct.setPrecio(pro.getPrecio());
                newProduct.setCantidad(pro.getCantidad());
                newProduct.setFoto(pro.getFoto());

                newProduct = repository.save(newProduct);

                return newProduct;
            } else {
                pro = repository.save(pro);

                return pro;
            }
        }
    }

    public void deleteProductosById(Long id) throws RecordNotFoundException {
        Optional<ProductosEntity> product = repository.findById(id);

        if (product.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No existe la Id");
        }
    }
}
