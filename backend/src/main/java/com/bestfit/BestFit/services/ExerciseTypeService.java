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
        if (!name.isEmpty()) return exerciseTypeRepository.findByName(name);
        return null;
    }

    public List<ExerciseType> findByPrimaryMuscleGroup(ExerciseType.MuscleGroup primaryMuscleGroup) {
        return exerciseTypeRepository.findByPrimaryMuscleGroup(primaryMuscleGroup);
    }

    public List<ExerciseType> findBySecondaryMuscleGroup(ExerciseType.MuscleGroup primaryMuscleGroup, ExerciseType.MuscleGroup secondaryMuscleGroup) {
        List<ExerciseType> allForPrimaryMuscleGroup = exerciseTypeRepository.findByPrimaryMuscleGroup(primaryMuscleGroup);

        List<ExerciseType> allWithSecondaryMuscleGroup = new ArrayList<>();

        for (ExerciseType exerciseType : allForPrimaryMuscleGroup) {
            if (exerciseType != null && exerciseType.getSecondaryMuscleGroups().contains(secondaryMuscleGroup)) {
                allWithSecondaryMuscleGroup.add(exerciseType);
            }
        }

        return allWithSecondaryMuscleGroup;
    }

    public void updateVideo(String name, String url) {
        ExerciseType exerciseType = findByName(name);
        if (exerciseType != null) {
            exerciseType.setVideoUrl(url);
            exerciseTypeRepository.save(exerciseType);
        }
    }

    public void deleteExerciseByName(String name) {
        ExerciseType exerciseType = findByName(name);
        if (exerciseType != null) exerciseTypeRepository.delete(exerciseType);
    }


}
