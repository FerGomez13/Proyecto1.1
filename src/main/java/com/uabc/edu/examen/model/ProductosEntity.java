package com.uabc.edu.examen.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "PRODUCTOS")
public class ProductosEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "producto")
    private String producto;

    @Column(name = "precio")
    private int precio;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "str", nullable = true)
    private String str;

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setId(long id) { this.id = id; }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public byte[] getFoto() {
        return foto;
    }

    public Long getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "ProductosEntity{" +
                "id=" + id +
                ", foto=" + Arrays.toString(foto) +
                ", producto='" + producto +
                ", precio='" + precio +
                ", cantidad='" + cantidad +
                ", str='" + str +
                '}';
    }
}
