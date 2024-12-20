package com.bestfit.BestFit.repositories;

import com.bestfit.BestFit.entities.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {

    Exercise findByName(String name);
    List<Exercise> findByPrimaryMuscleGroup(Exercise.MuscleGroup primaryMuscleGroup);

}
