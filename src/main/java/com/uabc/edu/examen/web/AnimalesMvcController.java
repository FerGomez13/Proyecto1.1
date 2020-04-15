package com.uabc.edu.examen.web;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.uabc.edu.examen.exception.RecordNotFoundException;
import com.uabc.edu.examen.model.AnimalesEntity;
import com.uabc.edu.examen.service.AnimalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class AnimalesMvcController {
    @Autowired
    private AnimalesService service;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/info")
    public String getAnimals(Model model) //Consulta General
    {
        List<AnimalesEntity> animal = service.getAnimals();

        model.addAttribute("animal", animal);
        return "consulta";
    }

    @RequestMapping("/modificar")
    public String getAnimalsM(Model model) //Consulta General
    {
        List<AnimalesEntity> animal = service.getAnimals();

        model.addAttribute("animal", animal);
        return "consultaM";
    }

    
     @RequestMapping("/Inicio")
    public String inicio(Model model) {
        model.addAttribute("animal", new AnimalesEntity());
        return "create";
    }

    @RequestMapping("/edit")
    public String update() {
         return "modificar";
     }

     @RequestMapping(path = {"/editar/{id}"})
    public String editAnimalesById(Model model, @PathVariable(value = "id", required = true) Long id) {
            AnimalesEntity animal = service.getAnimalById(id);
            model.addAttribute("animal", animal);
        return "modificar";
    }

    @RequestMapping(path = {"/adopt/{id}"})
    public String editAnimalesByIdA(Model model, @PathVariable(value = "id", required = true) Long id) {
        AnimalesEntity animal = service.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "adoptar";
    }

    @RequestMapping(path = {"/delete", "/delete/{id}"})
    public String deleteAnimalesById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteAnimalesById(id);
        return "redirect:/info";
    }

    @RequestMapping(path = "/createAnimal", method = RequestMethod.POST)
    public String createAnimal(@RequestParam(value = "id", required = false) Optional<Long> id,
                                     @RequestParam(value = "nombre", required = true) String nombre,
                                     @RequestParam(value = "tipo", required = true) String tipo,
                                     @RequestParam(value = "raza", required = true) String raza,
                                     @RequestParam(value = "color", required = true) String color,
                                     @RequestParam(value = "pelaje", required = true) String pelaje,
                                     @RequestParam(value = "fechaNacimiento", required = true) String fecha,
                                     @RequestParam(value = "vacunas", required = true) String vacunas,
                                     @RequestParam(value = "adopcion", required = false, defaultValue = "Disponible") String adopcion,
                                     @RequestParam(value = "nombre_adopcion", required = false, defaultValue = "Ninguno") String nombre_adopcion,
                                     @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {

        AnimalesEntity animalEntity;
        if (id.isPresent()) {
            animalEntity = service.getAnimalById(id.get());
        } else{
            animalEntity = new AnimalesEntity(); //empty entity
        }
        animalEntity.setNombre(nombre);
        animalEntity.setTipo(tipo);
        animalEntity.setRaza(raza);
        animalEntity.setColor(color);
        animalEntity.setPelaje(pelaje);
        animalEntity.setFechaNacimiento(fecha);
        animalEntity.setVacunas(vacunas);
        animalEntity.setAdopcion(adopcion);
        animalEntity.setNombre_adopcion(nombre_adopcion);

        try {
            animalEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        animalEntity.setStr(Base64.getEncoder().encodeToString(animalEntity.getFoto()));
        service.createAnimal(animalEntity);
        return "redirect:/info";
    }

    @RequestMapping(path = "/updateAnimal", method = RequestMethod.POST)
    public String updateAnimal(@RequestParam(value = "id", required = false) Optional<Long> id,
                               @RequestParam(value = "nombre", required = true) String nombre,
                               @RequestParam(value = "tipo", required = true) String tipo,
                               @RequestParam(value = "raza", required = true) String raza,
                               @RequestParam(value = "color", required = true) String color,
                               @RequestParam(value = "pelaje", required = true) String pelaje,
                               @RequestParam(value = "fechaNacimiento", required = true) String fecha,
                               @RequestParam(value = "vacunas", required = true) String vacunas,
                               @RequestParam(value = "adopcion", required = false, defaultValue = "Disponible") String adopcion,
                               @RequestParam(value = "nombre_adopcion", required = false, defaultValue = "Ninguno") String nombre_adopcion,
                               @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {

        AnimalesEntity animalEntity;
        if (id.isPresent()) {
            animalEntity = service.getAnimalById(id.get());
        } else{
            animalEntity = new AnimalesEntity();
        }
        animalEntity.setNombre(nombre);
        animalEntity.setTipo(tipo);
        animalEntity.setRaza(raza);
        animalEntity.setColor(color);
        animalEntity.setPelaje(pelaje);
        animalEntity.setFechaNacimiento(fecha);
        animalEntity.setVacunas(vacunas);
        animalEntity.setAdopcion(adopcion);
        animalEntity.setNombre_adopcion(nombre_adopcion);
        try {
            animalEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        animalEntity.setStr(Base64.getEncoder().encodeToString(animalEntity.getFoto()));
        service.createAnimal(animalEntity);
        return "redirect:/info";
    }



    @RequestMapping("/eliminar")
    public String getAnimalsBajas(Model model) //Consulta
    {
        List<AnimalesEntity> animal = service.getAnimals();

        model.addAttribute("animal", animal);
        return "eliminar";
    }

    @RequestMapping("/adoptar")
    public String getAnimalsAdop(Model model) //Consulta
    {
        List<AnimalesEntity> animal = service.getAnimals();

        model.addAttribute("animal", animal);
        return "consultaA";
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
                                 @RequestParam(value = "adopcion", required = false, defaultValue = "Disponible") String adopcion,
                                 @RequestParam(value = "nombre_adopcion", required = false) String nombre_adopcion,
                                 @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {
        AnimalesEntity animalEntity;
        if (id.isPresent()) {
            animalEntity = service.getAnimalById(id.get());
        } else{
            animalEntity = new AnimalesEntity();
        }
        animalEntity.setNombre(nombre);
        animalEntity.setTipo(tipo);
        animalEntity.setRaza(raza);
        animalEntity.setColor(color);
        animalEntity.setPelaje(pelaje);
        animalEntity.setFechaNacimiento(fecha);
        animalEntity.setVacunas(vacunas);
        animalEntity.setAdopcion(adopcion);
        animalEntity.setNombre_adopcion(nombre_adopcion);
        try {
            animalEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        animalEntity.setStr(Base64.getEncoder().encodeToString(animalEntity.getFoto()));
        service.createAnimal(animalEntity);
        return "redirect:/info";
    }
}
