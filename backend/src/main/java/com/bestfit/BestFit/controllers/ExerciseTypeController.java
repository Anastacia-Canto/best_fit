package com.bestfit.BestFit.controllers;

import com.bestfit.BestFit.entities.ExerciseType;
import com.bestfit.BestFit.exceptions.NoExerciseTypeFoundException;
import com.bestfit.BestFit.services.ExerciseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseTypeController {

    @Autowired
    private ExerciseTypeService service;

    @GetMapping({"/api/exercise", "/api/exercise/"})
    public ResponseEntity<List<ExerciseType>> getAllExercises() {
        List<ExerciseType> exercises = service.findAllExercises();
        if (exercises.isEmpty()) throw new NoExerciseTypeFoundException();
        return ResponseEntity.ok().body(exercises);
    }
}
