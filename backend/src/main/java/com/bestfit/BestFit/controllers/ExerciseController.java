package com.bestfit.BestFit.controllers;

import com.bestfit.BestFit.entities.Exercise;
import com.bestfit.BestFit.exceptions.NoExerciseFoundException;
import com.bestfit.BestFit.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @GetMapping({"/api/exercise", "/api/exercise/"})
    public ResponseEntity<List<Exercise>> getAllExercises() {
        List<Exercise> exercises = service.findAll();

        if (exercises.isEmpty()) throw new NoExerciseFoundException();
        return ResponseEntity.ok().body(exercises);
    }
}
