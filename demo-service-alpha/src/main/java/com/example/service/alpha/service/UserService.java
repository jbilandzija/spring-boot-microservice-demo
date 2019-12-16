package com.example.service.alpha.service;

import com.example.service.alpha.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(User user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(long id);

    void update(User user);
}
