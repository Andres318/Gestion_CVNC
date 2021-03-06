package com.andres.users.mapper;

import com.andres.users.dto.UserDTO;
import com.andres.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper of User
 * History -technical test- users CRUD
 * @author Andres Valenzuela
 * @since 1.0
 *
 */

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Dto to Entity
    /**
     * Converts from DTO User to its ENTITY
     *
     * @param userDTO
     */
    /*@Mapping(target = "id", source = "id")
    @Mapping(target = "identificacion", source = "identificacion")
    @Mapping(target = "telefono", source = "telefono")     //Como los campos son homonimos, Mapstruct infiere estos mappings
    @Mapping(target = "nombre", source = "nombre")*/
    User toUser(UserDTO userDTO);


    // Entity to Dto
    /**
     * Converts from User to its DTO
     *
     * @param user
     */
    UserDTO toUserDTO(User user);
}
