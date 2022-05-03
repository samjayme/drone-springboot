package com.samuelspringboot.dronespringboot.serviceException;

public class DroneLimitExceededException extends Exception{
    public DroneLimitExceededException(String message) {
        super(message);
    }
}
