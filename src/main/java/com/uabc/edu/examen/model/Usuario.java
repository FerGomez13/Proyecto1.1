package com.uabc.edu.examen.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String rol;
    private boolean active;

    public Usuario(String username, String password, String rol, boolean active) {
        this.active = active;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Usuario() {
    }
}
