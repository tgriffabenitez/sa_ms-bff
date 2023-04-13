package com.sistemasactivos.msbff.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String pais;
    private String codigoPostal;
    private String cuit;

}
