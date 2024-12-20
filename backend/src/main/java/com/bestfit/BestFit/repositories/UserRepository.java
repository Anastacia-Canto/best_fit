package com.bestfit.BestFit.repositories;

import com.bestfit.BestFit.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);
    List<User> findByRole(String role);
}
