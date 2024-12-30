package com.bestfit.BestFit.services;

import com.bestfit.BestFit.entities.Exercise;
import com.bestfit.BestFit.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> findAll() {
        return (List<Exercise>) exerciseRepository.findAll();
    }

    public Exercise findByType(String type) {
        if (!type.isEmpty()) {
            return findAll()
                    .stream()
                    .filter(exercise -> exercise.getType().getName().equalsIgnoreCase(type))
                    .toList()
                    .get(0);
        }
        return null;
    }
}
