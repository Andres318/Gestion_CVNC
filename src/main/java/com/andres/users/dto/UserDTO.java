package com.andres.users.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO to receive data from User
 * History -technical test- users CRUD
 * @author Andres Valenzuela
 * @since 1.0
 **/

@Getter
@Setter
@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -2702069230234858968L;


    private Long id;

    private Long identificacion;

    private Long telefono;

    private String nombre;

}
