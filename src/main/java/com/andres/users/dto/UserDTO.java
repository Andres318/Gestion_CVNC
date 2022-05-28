package com.andres.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -2702069230234858968L;

    private Long id;

    private Long identificacion;

    private Long telefono;

    private String nombre;

}
