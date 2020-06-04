package com.uabc.edu.examen.repository;

import com.uabc.edu.examen.model.GuarderiaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuarderiaRepository extends CrudRepository<GuarderiaEntity, Long> {
}
