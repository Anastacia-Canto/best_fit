package com.bestfit.BestFit.repositories;

import com.bestfit.BestFit.entities.ExerciseType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseTypeRepository extends CrudRepository<ExerciseType, Integer> {

    ExerciseType findByName(String name);
    List<ExerciseType> findByPrimaryMuscleGroup(ExerciseType.MuscleGroup primaryMuscleGroup);

}
