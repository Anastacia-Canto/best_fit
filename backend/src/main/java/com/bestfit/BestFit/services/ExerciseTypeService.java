package com.bestfit.BestFit.services;

import com.bestfit.BestFit.entities.ExerciseType;
import com.bestfit.BestFit.repositories.ExerciseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseTypeService {

    @Autowired
    private ExerciseTypeRepository exerciseTypeRepository;

    public List<ExerciseType> findAllExercises() {
        return (List<ExerciseType>) exerciseTypeRepository.findAll();
    }

    public ExerciseType findByName(String name) {
        return exerciseTypeRepository.findByName(name);
    }

    public List<ExerciseType> findByPrimaryMuscleGroup(ExerciseType.MuscleGroup primaryMuscleGroup) {
        return exerciseTypeRepository.findByPrimaryMuscleGroup(primaryMuscleGroup);
    }


    List<ExerciseType> findBySecondaryMuscleGroup(ExerciseType.MuscleGroup primaryMuscleGroup, ExerciseType.MuscleGroup secondaryMuscleGroup) {
        List<ExerciseType> allForPrimaryMuscleGroup = exerciseTypeRepository.findByPrimaryMuscleGroup(primaryMuscleGroup);

        List<ExerciseType> allWithSecondaryMuscleGroup = new ArrayList<>();

        for (ExerciseType exerciseType : allForPrimaryMuscleGroup) {
            if (exerciseType.getSecondaryMuscleGroups().contains(secondaryMuscleGroup)) {
                allWithSecondaryMuscleGroup.add(exerciseType);
            }
        }

        return allWithSecondaryMuscleGroup;
    }

    public void updateVideo(String name, String url) {
        ExerciseType exerciseType = exerciseTypeRepository.findByName(name);
        exerciseType.setVideoUrl(url);
        exerciseTypeRepository.save(exerciseType);
    }

    public void deleteExerciseByName(String name) {
        ExerciseType exerciseType = exerciseTypeRepository.findByName(name);
        exerciseTypeRepository.delete(exerciseType);
    }


}
