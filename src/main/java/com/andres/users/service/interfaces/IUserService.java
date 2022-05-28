package com.andres.users.service.interfaces;

import com.andres.users.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<User> getAll();

    User getUser(Long id);
}
