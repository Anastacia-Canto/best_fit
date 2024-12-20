package com.bestfit.BestFit.config;

import com.bestfit.BestFit.entities.Exercise;
import com.bestfit.BestFit.entities.User;
import com.bestfit.BestFit.repositories.ExerciseRepository;
import com.bestfit.BestFit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class BestFitConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("personal", "Marta");
        User user2 = new User("client", "Fernando");

        Exercise ex = new Exercise("chest press", "pectoralis", Arrays.asList("deltoid", "triceps"), "https://www.youtube.com/watch?v=n8TOta_pfr4");

        Exercise ex2 = new Exercise("romanian deadlift", "legs", Arrays.asList("gluteus", "back"), "https://www.youtube.com/watch?v=7j-2w4-P14I");

        Exercise ex3 = new Exercise("crunch", "core", Arrays.asList("back", "chest"), "https://www.youtube.com/watch?v=Xyd_fa5zoEU");

        userRepository.save(user1);
        userRepository.save(user2);

        exerciseRepository.save(ex);
        exerciseRepository.save(ex2);
        exerciseRepository.save(ex3);
    }
}
