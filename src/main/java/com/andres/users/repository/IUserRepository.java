package com.andres.users.repository;

import com.andres.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for User
 * History -technical test- users CRUD
 * @author Andres Valenzuela
 * @since 1.0
 */

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
