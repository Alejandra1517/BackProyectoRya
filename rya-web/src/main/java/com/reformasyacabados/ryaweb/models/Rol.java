package com.reformasyacabados.ryaweb.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer id_rol;

    @Column(name = "nombre_rol")
    private String nombre_rol;


    @OneToOne(mappedBy = "rol")
    private Usuario usuario;

}
