package com.reformasyacabados.ryaweb.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data

@Entity
@Table(name = "Materiales")
public class Material {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    int id_material;

    String nombre_material;

    String proveedor;

    int estado;

    Date fecha_ingreso;



}
