package com.prueba.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="individuo")
public class Individuo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_individuo;

    @NotEmpty //Anotacion para validar que un campo no sea vacio
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    private String telefono;

    @NotEmpty
    @Email //Anotacion para validar que un campo sea un correo
    private String correo;

    private int edad;

}
