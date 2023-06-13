package com.reformasyacabados.ryaweb.models;

import javax.persistence.*;

import lombok.Data;


@Data

@Entity
@Table(name = "Empleados")
public class Empleado {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    int id_empleado;

    String nombre;

    String telefono;

    String documento;

    String direccion;

    int estado;


}
