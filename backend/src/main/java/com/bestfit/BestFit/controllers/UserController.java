package com.bestfit.BestFit.controllers;

import com.bestfit.BestFit.entities.User;
import com.bestfit.BestFit.exceptions.NoUserRegisteredException;
import com.bestfit.BestFit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/api/user", "/api/user/"})
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        if (users.isEmpty()) throw new NoUserRegisteredException();
        return ResponseEntity.ok().body(users);
    }


}
