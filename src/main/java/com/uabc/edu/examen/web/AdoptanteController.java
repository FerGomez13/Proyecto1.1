 package com.uabc.edu.examen.web;

import com.uabc.edu.examen.model.AnimalesEntity;
import com.uabc.edu.examen.service.AnimalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

 @Controller
 @RequestMapping("/adopcion")
 public class AdoptanteController {

     @Autowired
     private AnimalesService service;

     @RequestMapping(path = {"/adopt/{id}"})
     public String editAnimalesByIdA(Model model, @PathVariable(value = "id", required = true) Long id) {
         AnimalesEntity animal = service.getAnimalById(id);
         model.addAttribute("animal", animal);
         return "adoptarCreate";
     }

     @RequestMapping(path = "/adoptateAnimal", method = RequestMethod.POST)
     public String adoptateAnimal(@RequestParam(value = "id", required = false) Optional<Long> id,
                                  @RequestParam(value = "nombre", required = true) String nombre,
                                  @RequestParam(value = "tipo", required = true) String tipo,
                                  @RequestParam(value = "raza", required = true) String raza,
                                  @RequestParam(value = "color", required = true) String color,
                                  @RequestParam(value = "pelaje", required = true) String pelaje,
                                  @RequestParam(value = "fechaNacimiento", required = true) String fecha,
                                  @RequestParam(value = "vacunas", required = true) String vacunas,
                                  @RequestParam(value = "adopcion", required = false) String adopcion,
                                  @RequestParam(value = "nombre_adopcion", required = false) String nombre_adopcion,
                                  @RequestParam(value = "foto", required = false) MultipartFile foto) {
         AnimalesEntity animalEntity;
         if (id.isPresent()) {
             animalEntity = service.getAnimalById(id.get());
         } else{
             animalEntity = new AnimalesEntity();
         }
         System.out.println(animalEntity.toString());
         animalEntity.setNombre(nombre);
         animalEntity.setTipo(tipo);
         animalEntity.setRaza(raza);
         animalEntity.setColor(color);
         animalEntity.setPelaje(pelaje);
         animalEntity.setFechaNacimiento(fecha);
         animalEntity.setVacunas(vacunas);
         animalEntity.setAdopcion("Adoptado");
         animalEntity.setNombre_adopcion(nombre_adopcion);
         animalEntity.setFoto(animalEntity.getFoto());
         animalEntity.setStr(animalEntity.getStr());
         System.out.println(animalEntity.getId()+"hola mi amigo");
         service.createAnimal(animalEntity);

         return "redirect:/adoptar";
     }
 }