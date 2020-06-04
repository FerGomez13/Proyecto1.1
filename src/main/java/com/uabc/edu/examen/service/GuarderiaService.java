package com.uabc.edu.examen.service;

import com.uabc.edu.examen.exception.RecordNotFoundException;
import com.uabc.edu.examen.model.GuarderiaEntity;
import com.uabc.edu.examen.repository.GuarderiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuarderiaService {

    @Autowired
    GuarderiaRepository repository;

    public List<GuarderiaEntity> getGuarderias() {
        return (List<GuarderiaEntity>) repository.findAll();
    }

    public GuarderiaEntity getGuardById(Long id){
        Optional<GuarderiaEntity> guard = repository.findById(id);

        if (guard.isPresent()) {
            return repository.findById(id).get();
        }
        return guard.get();
    }

    public GuarderiaEntity createGuard(GuarderiaEntity gua) {
        if (gua.getId() == null) {
            gua = repository.save(gua);

            return gua;
        } else {
            Optional<GuarderiaEntity> guard = repository.findById(gua.getId());
            if (guard.isPresent()) {
                GuarderiaEntity newGuard = guard.get();
                newGuard.setId(gua.getId());
                newGuard.setNombre(gua.getNombre());
                newGuard.setRaza(gua.getRaza());
                newGuard.setColor(gua.getColor());
                newGuard.setVacunas(gua.getVacunas());
                newGuard.setTipo(gua.getTipo());
                newGuard.setCosto(gua.getCosto());
                newGuard.setFoto(gua.getFoto());

                newGuard = repository.save(newGuard);

                return newGuard;
            } else {
                gua = repository.save(gua);

                return gua;
            }
        }
    }

    public void deleteGuarderiasById(Long id) throws RecordNotFoundException {
        Optional<GuarderiaEntity> guard = repository.findById(id);

        if (guard.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No existe la Id");
        }
    }
}