package com.bestfit.BestFit.config;

import com.bestfit.BestFit.entities.Exercise;
import com.bestfit.BestFit.entities.ExerciseType;
import com.bestfit.BestFit.entities.User;
import com.bestfit.BestFit.repositories.ExerciseRepository;
import com.bestfit.BestFit.repositories.ExerciseTypeRepository;
import com.bestfit.BestFit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.Arrays;

@Configuration
public class BestFitConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExerciseTypeRepository exerciseTypeRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("personal", "Marta");
        User user2 = new User("client", "Fernando");

        ExerciseType ex = new ExerciseType("chest press", "pectoralis", Arrays.asList("deltoid", "triceps"), "https://www.youtube.com/watch?v=n8TOta_pfr4");

        ExerciseType ex2 = new ExerciseType("romanian deadlift", "legs", Arrays.asList("gluteus", "back"), "https://www.youtube.com/watch?v=7j-2w4-P14I");

        ExerciseType ex3 = new ExerciseType("crunch", "core", Arrays.asList("back", "chest"), "https://www.youtube.com/watch?v=Xyd_fa5zoEU");

        Exercise exercise = new Exercise(ex, 3, 10, LocalTime.parse("00:01:30"), LocalTime.parse("00:00:00"));

        userRepository.save(user1);
        userRepository.save(user2);

        exerciseTypeRepository.save(ex);
        exerciseTypeRepository.save(ex2);
        exerciseTypeRepository.save(ex3);

        exerciseRepository.save(exercise);
    }
}
