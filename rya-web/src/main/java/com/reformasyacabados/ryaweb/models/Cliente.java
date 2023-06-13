package com.reformasyacabados.ryaweb.models;

import lombok.Data;

import javax.persistence.*;


@Data

@Entity
@Table(name = "Clientes")
public class Cliente {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    int id_cliente;

    String nombre_cliente;

    String documento;

    String telefono;

    String direccion;

    int estado;


}
