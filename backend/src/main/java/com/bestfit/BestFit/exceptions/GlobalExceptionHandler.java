package com.bestfit.BestFit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoUserRegisteredException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    RestErrorResponse handleNoUserRegisteredException(NoUserRegisteredException e) {
        return new RestErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(NoExerciseTypeFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    RestErrorResponse handleNoExerciseTypeFoundException(NoExerciseTypeFoundException e) {
        return new RestErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
