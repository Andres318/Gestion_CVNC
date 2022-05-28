package com.andres.users.service.impl;

import com.andres.users.model.User;
import com.andres.users.repository.IUserRepository;
import com.andres.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    @Override
    public List<User> getAll(){
        return this.userRepository.findAll();
    }


    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
