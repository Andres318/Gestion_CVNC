package com.andres.users.controller;

import com.andres.users.dto.UserDTO;
import com.andres.users.mapper.UserMapper;
import com.andres.users.model.User;
import com.andres.users.repository.IUserRepository;
import com.andres.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(usuarios.stream().map(UserMapper.INSTANCE::toUserDTO).collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
