package com.bestfit.BestFit.exceptions;

public class NoExerciseFoundException extends RuntimeException {
    public NoExerciseFoundException() {
        super("No exercise found.");
    }
}
