package com.uabc.edu.examen.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name= "GUARDERIA")
public class GuarderiaEntity {

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

    @Column(name = "vacunas")
    private String vacunas;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha_entrada")
    private String fecha_entrada;

    @Column(name = "fecha_salida")
    private String fecha_salida;

    @Column(name = "costo")
    private int costo;

    @Column(name = "str", nullable = true)
    private String str;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Long getId() {
        return id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    public String getVacunas() {
        return vacunas;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public int getCosto() {
        return costo;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "GuaderiaEntity{" +
                "id=" + id +
                ", nombre='" + nombre +
                ", raza='" + raza +
                ", color='" + color +
                ", vacunas='" + vacunas +
                ", tipo='" + tipo +
                ", fecha_entrada='" + fecha_entrada +
                ", fecha_salida='" + fecha_salida +
                ", costo=" + costo +
                ", foto=" + Arrays.toString(foto) +
                ", str='" + str +
                '}';
    }
}
