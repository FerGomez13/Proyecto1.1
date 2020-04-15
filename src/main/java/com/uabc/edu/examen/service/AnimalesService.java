package com.uabc.edu.examen.service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.uabc.edu.examen.exception.RecordNotFoundException;
import com.uabc.edu.examen.model.AnimalesEntity;
import com.uabc.edu.examen.repository.AnimalesRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AnimalesService {

    @Autowired
    AnimalesRepository repository;

       public List<AnimalesEntity> getAnimals() {
        return (List<AnimalesEntity>) repository.findAll();
        }

    public AnimalesEntity getAnimalById(Long id){
        Optional<AnimalesEntity> animal = repository.findById(id);

        if (animal.isPresent()) {
            return repository.findById(id).get();
        }
            return animal.get();
    }

    public AnimalesEntity createAnimal(AnimalesEntity ani) {
        if (ani.getId() == null) {
            ani = repository.save(ani);

            return ani;
        } else {
            Optional<AnimalesEntity> animal = repository.findById(ani.getId());
            if (animal.isPresent()) {
                AnimalesEntity newAnimal = animal.get();
                newAnimal.setId(ani.getId());
                newAnimal.setNombre(ani.getNombre());
                newAnimal.setRaza(ani.getRaza());
                newAnimal.setColor(ani.getColor());
                newAnimal.setPelaje(ani.getPelaje());
                newAnimal.setFechaNacimiento(ani.getFechaNacimiento());
                newAnimal.setVacunas(ani.getVacunas());
                newAnimal.setAdopcion(ani.getAdopcion());
                newAnimal.setNombre_adopcion(ani.getNombre_adopcion());
                newAnimal.setTipo(ani.getTipo());
                newAnimal.setFoto(ani.getFoto());

                newAnimal = repository.save(newAnimal);

                return newAnimal;
            } else {
                ani = repository.save(ani);

                return ani;
            }
        }
    }

    public void deleteAnimalesById(Long id) throws RecordNotFoundException {
        Optional<AnimalesEntity> animal = repository.findById(id);

        if (animal.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No existe la Id");
        }
    }
}
