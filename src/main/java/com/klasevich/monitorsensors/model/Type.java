package com.klasevich.monitorsensors.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    PRESSURE("pressure"),
    VOLTAGE("voltage"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity");

    private final String externalValue;

    Type(String externalValue) {
        this.externalValue = externalValue;
    }

    @JsonValue
    public String getExternalValue() {
        return externalValue;
    }
}