package com.uabc.edu.examen.model;

import javax.persistence.*;
import java.awt.*;
import java.util.Arrays;


@Entity
@Table(name = "TBL_ANIMALES")
public class AnimalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "raza")
    private String raza;

    @Column(name = "color")
    private String color;

    @Column(name = "pelaje")
    private String pelaje;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "vacunas")
    private String vacunas;

    @Column(name = "adopcion")
    private String adopcion;

    @Column(name = "nombre_adopcion")
    private String nombre_adopcion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "str", nullable = true)
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public String getAdopcion() {
        return adopcion;
    }

    public void setAdopcion(String adopcion) {
        this.adopcion = adopcion;
    }

    public String getNombre_adopcion() {
        return nombre_adopcion;
    }

    public void setNombre_adopcion(String nombre_adopcion) {
        this.nombre_adopcion = nombre_adopcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "AnimalesEntity{" +
                "id=" + id +
                ", foto=" + Arrays.toString(foto) +
                ", nombre='" + nombre +
                ", raza='" + raza +
                ", color='" + color +
                ", pelaje='" + pelaje +
                ", fechaNacimiento='" + fechaNacimiento +
                ", vacunas='" + vacunas +
                ", adopcion='" + adopcion +
                ", nombre_adopcion='" + nombre_adopcion +
                ", tipo='" + tipo +
                ", foto=" + Arrays.toString(foto) +
                ", str='" + str +
                '}';
    }
}
