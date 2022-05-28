package com.andres.users.service.impl;

import com.andres.users.model.User;
import com.andres.users.repository.IUserRepository;
import com.andres.users.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Interface Implementation to Users
 * History -technical test- users CRUD
 * @author Andres Valenzuela
 * @since 1.0
 **/


@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    /**
     * Get all registers from User
     */
    @Override
    public List<User> getAll(){
        return this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * Get User by Id
     * @param id
     */
    @Override
    public User getUser(Long id){
        return this.userRepository.findById(id).orElse(null);
    }

    /**
     * Create a User
     * @param user
     */
    @Override
    public User createUser(User user){
        return this.userRepository.save(user);
    }

    /**
     * Update a User
     * @param user
     */
    @Override
    public User updateUser(User user){
        return this.userRepository.save(user);
    }

    /**
     * Delete a User
     * @param id
     */
    @Override
    public Boolean deleteUser(Long id){
        this.userRepository.deleteById(id);
        return true;
    }

    /**
     * Delete all Users
     */
    @Override
    public Boolean deleteAllUser(){
        if (this.userRepository.count() == 0){
            return false;
        }
        else {
            this.userRepository.deleteAll();
            return true;
        }

    }


    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
