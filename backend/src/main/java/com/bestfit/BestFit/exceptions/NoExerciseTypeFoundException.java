package com.bestfit.BestFit.exceptions;

public class NoExerciseTypeFoundException extends RuntimeException {
    public NoExerciseTypeFoundException() {
        super("No exercise type found.");
    }
}
