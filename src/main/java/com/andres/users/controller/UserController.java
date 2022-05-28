package com.andres.users.controller;

import com.andres.users.dto.UserDTO;
import com.andres.users.mapper.UserMapper;
import com.andres.users.model.User;
import com.andres.users.service.interfaces.IUserService;
import com.andres.users.util.IConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class to Users
 * History -technical test- users CRUD
 * @author Andres Valenzuela
 * @since 1.0
 *
 */


@RestController
@RequestMapping("/api/user")
public class UserController {

    private IUserService userService;

    /**
     * Get all registers from User
     */
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> usuarios = this.userService.getAll();
        if (usuarios == null || usuarios.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.SIN_USUARIOS);
        }
        else {
            return new ResponseEntity<>(usuarios.stream().map(UserMapper.INSTANCE::toUserDTO).collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    /**
     * Get User by Id
     * @param id
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(value = "id") Long id) throws ResponseStatusException {
        User user = this.userService.getUser(id);
        if (user != null){
            return new ResponseEntity<>(UserMapper.INSTANCE.toUserDTO(user), HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.USUARIO_NO_ENCONTRADO);
        }
    }

    /**
     * Create a User
     * @param userDTO
     */
    @PostMapping("/new")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){

        if (userDTO.getIdentificacion() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.DOCUMENTO_INVALIDO);
        }

        if (userDTO.getNombre() == null ||  userDTO.getNombre().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.NOMBRE_INVALIDO);
        }

        User newUser = this.userService.createUser(UserMapper.INSTANCE.toUser(userDTO));
        return new ResponseEntity<>(UserMapper.INSTANCE.toUserDTO(newUser), HttpStatus.CREATED);
    }

    /**
     * Update a User
     * @param userDTO
     */
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        if (userDTO.getId() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.ID_VACIO);
        }
        
        if (this.userService.getUser(userDTO.getId()) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.USUARIO_NO_ENCONTRADO);
        }

        if (userDTO.getIdentificacion() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.DOCUMENTO_INVALIDO);
        }

        if (userDTO.getNombre() == null ||  userDTO.getNombre().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.NOMBRE_INVALIDO);
        }

        else {
            return new ResponseEntity<>(UserMapper.INSTANCE.toUserDTO
                    (this.userService.updateUser(UserMapper.INSTANCE.toUser(userDTO))), HttpStatus.OK);
        }
    }

    /**
     * Delete a User
     * @param id
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "id") Long id){
        User user = this.userService.getUser(id);
        if (user != null){
            this.userService.deleteUser(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, IConstantes.USUARIO_NO_ENCONTRADO);
        }
    }

    /**
     * Delete all User
     */
    @DeleteMapping("delete/all")
    public ResponseEntity<Boolean> deleteAllUser(){

        return new ResponseEntity<>(this.userService.deleteAllUser(), HttpStatus.OK);
    }


    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
