package com.andres.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class for the management of User (Entity)
 * History 3390 CRUD de tipos de apoyo por auxiliatura
 * @author Andres Valenzuela
 * @since 1.0
 **/

@Entity
@Data
@NoArgsConstructor
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = -4058108559122877352L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, insertable = false)
    private Long id;

    @Column(name = "IDENTIFICACION", nullable = false)
    private Long identificacion;

    @Column(name = "TELEFONO")
    private Long telefono;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

}
