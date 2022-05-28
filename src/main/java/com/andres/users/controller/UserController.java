package com.andres.users.controller;

import com.andres.users.dto.UserDTO;
import com.andres.users.mapper.UserMapper;
import com.andres.users.model.User;
import com.andres.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> usuarios = this.userService.getAll();
        if (usuarios == null || usuarios.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay usuarios registrados");
        }
        else {
            return new ResponseEntity<>(usuarios.stream().map(UserMapper.INSTANCE::toUserDTO).collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable(value = "id") Long id) throws ResponseStatusException {
        User user = this.userService.getUser(id);
        if (user != null){
            return new ResponseEntity<>(UserMapper.INSTANCE.toUserDTO(user), HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id de usuario no encontrado");
        }
    }


    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
