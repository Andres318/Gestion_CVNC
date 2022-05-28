package com.andres.users.service.interfaces;

import com.andres.users.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service Interface to User
 * History -technical test- users CRUD
 * @author Andres Valenzuela
 * @since 1.0
 **/

@Service
public interface IUserService {

    List<User> getAll();

    User getUser(Long id);

    User createUser(User user);

    User updateUser(User user);

    Boolean deleteUser(Long id);

    Boolean deleteAllUser();
}
