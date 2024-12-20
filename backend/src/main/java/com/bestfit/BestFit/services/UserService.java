package com.bestfit.BestFit.services;

import com.bestfit.BestFit.entities.User;
import com.bestfit.BestFit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void updateUser(User user) {
        userRepository.save(user);
    }

}
