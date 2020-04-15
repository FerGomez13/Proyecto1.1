package com.uabc.edu.examen.repository;

import com.uabc.edu.examen.model.AnimalesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalesRepository extends CrudRepository<AnimalesEntity, Long> {
}
