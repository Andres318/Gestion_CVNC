package com.andres.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase para el manejo de la información de la tabla Usuarios
 *
 * @author Andres Valenzuela
 * @since 1.0
 *
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = -4058108559122877352L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "IDENTIFICACION")
    private Long identificacion;

    @Column(name = "TELEFONO")
    private Long telefono;

    @Column(name = "NOMBRE")
    private String nombre;

}
