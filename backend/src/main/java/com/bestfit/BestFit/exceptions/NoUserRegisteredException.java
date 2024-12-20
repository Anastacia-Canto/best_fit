package com.bestfit.BestFit.exceptions;

public class NoUserRegisteredException extends RuntimeException {
    public NoUserRegisteredException() {
        super("No user registered.");
    }
}
