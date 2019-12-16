package com.example.service.alpha.controller;

import com.example.service.alpha.model.User;
import com.example.service.alpha.service.UserService;
import org.hibernate.id.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import static java.lang.Math.toIntExact;
import static java.time.Instant.now;
import static java.time.ZoneId.systemDefault;
import static java.util.Objects.isNull;

/**
 * API implementation for the CRUD operations.
 */
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("users")
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.findAll();
        if (userList == null || userList.isEmpty()) {
            logger.info("Get users found no data at " + now().atZone(systemDefault()));
            return ResponseEntity.notFound().build();
        }
        logger.info("Get users api is called successfully at " + now().atZone(systemDefault()));
        return ResponseEntity.ok(userList);
    }

    //@Secured("ROLE_USER")
    //@PreAuthorize("hasRole('USER')")
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("users/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") Long id) {
        User user = userService.findById(toIntExact(id));
        if (user == null) {
            logger.info("Get user found no data with id (" + id + ") at " + now().atZone(systemDefault()));
            return ResponseEntity.notFound().build();
        }
        logger.info("Get user api is called successfully with id (" + id + ") at " + now().atZone(systemDefault()));
        return ResponseEntity.ok(user);
    }


    @PostMapping("users/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        if (user == null) {
            logger.info("Save user failed as user is null at " + now().atZone(systemDefault()));
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        if (userService.findById(user.getId()) != null) {
            logger.info("Save user ignored as user already exists at " + now().atZone(systemDefault()));
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return validateAndSaveUser(user);
    }

    private ResponseEntity<?> validateAndSaveUser(User user) {
        if (isNull(user.getFirstName()) || isNull(user.getLastName()) || isNull(user.getUsername()) || isNull(user.getPassword())) {
            logger.info("Provided entity has null fields. Cannot save. User: " + user + ", at " + now().atZone(systemDefault()));
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        userService.save(user);
        logger.info("Create api is called successfully at " + now().atZone(systemDefault()));
        return ResponseEntity.ok("User is created: " + user.getUsername());
    }

}
