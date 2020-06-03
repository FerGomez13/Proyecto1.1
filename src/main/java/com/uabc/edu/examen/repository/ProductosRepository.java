package com.uabc.edu.examen.repository;

import com.uabc.edu.examen.model.ProductosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProductosRepository  extends CrudRepository<ProductosEntity, Long> {
}
