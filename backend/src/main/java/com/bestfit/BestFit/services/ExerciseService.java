package com.bestfit.BestFit.services;

import com.bestfit.BestFit.entities.Exercise;
import com.bestfit.BestFit.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> findAllExercises() {
        return (List<Exercise>) exerciseRepository.findAll();
    }


    List<Exercise> findBySecondaryMuscleGroup(Exercise.MuscleGroup primaryMuscleGroup, Exercise.MuscleGroup secondaryMuscleGroup) {
        List<Exercise> allForPrimaryMuscleGroup = exerciseRepository.findByPrimaryMuscleGroup(primaryMuscleGroup);

        List<Exercise> allWithSecondaryMuscleGroup = new ArrayList<>();

        for (Exercise exercise : allForPrimaryMuscleGroup) {
            if (exercise.getSecondaryMuscleGroups().contains(secondaryMuscleGroup)) {
                allWithSecondaryMuscleGroup.add(exercise);
            }
        }

        return allWithSecondaryMuscleGroup;
    }

    public void updateVideo(String name, String url) {
        Exercise exercise = exerciseRepository.findByName(name);
        exercise.setVideoUrl(url);
        exerciseRepository.save(exercise);
    }

    public void deleteExerciseByName(String name) {
        Exercise exercise = exerciseRepository.findByName(name);
        exerciseRepository.delete(exercise);
    }


}
