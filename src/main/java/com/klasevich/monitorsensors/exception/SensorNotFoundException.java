package com.klasevich.monitorsensors.exception;

public class SensorNotFoundException extends RuntimeException {

    public SensorNotFoundException(String message) {
        super(message);
    }
}
