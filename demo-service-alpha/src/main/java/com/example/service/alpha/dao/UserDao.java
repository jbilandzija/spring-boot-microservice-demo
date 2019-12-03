package com.example.service.alpha.dao;

import com.example.service.alpha.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA.
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
