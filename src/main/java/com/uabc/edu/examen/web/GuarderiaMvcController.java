package com.uabc.edu.examen.web;

import com.uabc.edu.examen.exception.RecordNotFoundException;
import com.uabc.edu.examen.model.GuarderiaEntity;
import com.uabc.edu.examen.service.GuarderiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class GuarderiaMvcController {
    @Autowired
    private GuarderiaService service;

    @RequestMapping("/infoGuarderia")
    public String getGuarderias(Model model) //Consulta General
    {
        List<GuarderiaEntity> guard = service.getGuarderias();

        model.addAttribute("guard", guard);
        return "consultaGuarderia";
    }

    @RequestMapping("/modificarGuarderia")
    public String getGuarderiasM(Model model) //Consulta General
    {
        List<GuarderiaEntity> guard = service.getGuarderias();

        model.addAttribute("guard", guard);
        return "consultaMGuarderia";
    }

    @RequestMapping("/InicioGuarderia")
    public String inicio(Model model) {
        model.addAttribute("guard", new GuarderiaEntity());
        return "createGuarderia";
    }

    @RequestMapping("/editGuarderia")
    public String update() {
        return "modificarGuarderia";
    }

    @RequestMapping(path = {"/editarGuarderia/{id}"})
    public String editGuarderiasById(Model model, @PathVariable(value = "id", required = true) Long id) {
        GuarderiaEntity guard = service.getGuardById(id);
        model.addAttribute("guard", guard);
        return "modificarGuarderia";
    }

    @RequestMapping(path = {"/deleteGuarderia", "/deleteGuarderia/{id}"})
    public String deleteGuarderiasById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteGuarderiasById(id);
        return "redirect:/infoGuarderia";
    }

    @RequestMapping(path = "/createGuarderia", method = RequestMethod.POST)
    public String createGuard(@RequestParam(value = "id", required = false) Optional<Long> id,
                               @RequestParam(value = "nombre", required = true) String nombre,
                               @RequestParam(value = "raza", required = true) String raza,
                               @RequestParam(value = "color", required = true) String color,
                               @RequestParam(value = "vacunas", required = true) String vacunas,
                               @RequestParam(value = "tipo", required = true) String tipo,
                               @RequestParam(value = "fecha_entrada", required = true) String fecha_entrada,
                               @RequestParam(value = "fecha_salida", required = true) String fecha_salida,
                               @RequestParam(value = "costo", required = true) int costo,
                               @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {

        GuarderiaEntity guardEntity;
        if (id.isPresent()) {
            guardEntity = service.getGuardById(id.get());
        } else{
            guardEntity = new GuarderiaEntity(); //empty entity
        }
        guardEntity.setNombre(nombre);
        guardEntity.setRaza(raza);
        guardEntity.setColor(color);
        guardEntity.setVacunas(vacunas);
        guardEntity.setTipo(tipo);
        guardEntity.setFecha_entrada(fecha_entrada);
        guardEntity.setFecha_salida(fecha_salida);
        guardEntity.setCosto(costo);
        try {
            guardEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        guardEntity.setStr(Base64.getEncoder().encodeToString(guardEntity.getFoto()));
        service.createGuard(guardEntity);
        return "redirect:/infoGuarderia";
    }

    @RequestMapping(path = "/updateGuard", method = RequestMethod.POST)
    public String updateAnimal(@RequestParam(value = "id", required = false) Optional<Long> id,
                               @RequestParam(value = "nombre", required = true) String nombre,
                               @RequestParam(value = "raza", required = true) String raza,
                               @RequestParam(value = "color", required = true) String color,
                               @RequestParam(value = "vacunas", required = true) String vacunas,
                               @RequestParam(value = "tipo", required = true) String tipo,
                               @RequestParam(value = "fecha_entrada", required = true) String fecha_entrada,
                               @RequestParam(value = "fecha_salida", required = true) String fecha_salida,
                               @RequestParam(value = "costo", required = true) int costo,
                               @RequestParam(value = "foto", required = false, defaultValue = "No disponible") MultipartFile foto) {

        GuarderiaEntity guardEntity;
        if (id.isPresent()) {
            guardEntity = service.getGuardById(id.get());
        } else{
            guardEntity = new GuarderiaEntity();
        }
        guardEntity.setNombre(nombre);
        guardEntity.setRaza(raza);
        guardEntity.setColor(color);
        guardEntity.setVacunas(vacunas);
        guardEntity.setTipo(tipo);
        guardEntity.setFecha_entrada(fecha_entrada);
        guardEntity.setFecha_salida(fecha_salida);
        guardEntity.setCosto(costo);
        try {
            guardEntity.setFoto(foto.getBytes());
        } catch (Exception e) {
            System.out.println("SAVE ANIMAL ERROR: >>> " + e);
        }
        System.out.println(guardEntity.getId());
        guardEntity.setStr(Base64.getEncoder().encodeToString(guardEntity.getFoto()));
        service.createGuard(guardEntity);
        return "redirect:/infoGuarderia";
    }

    @RequestMapping("/eliminarGuarderia")
    public String getGuarderiasBajas(Model model) //Consulta
    {
        List<GuarderiaEntity> guard = service.getGuarderias();

        model.addAttribute("guard", guard);
        return "eliminarGuarderia";
    }
}