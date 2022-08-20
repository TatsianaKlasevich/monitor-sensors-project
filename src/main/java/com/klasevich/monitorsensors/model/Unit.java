package com.klasevich.monitorsensors.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Unit {
    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("°С"),
    PERCENT("%");

    private final String externalValue;

    Unit(String externalValue) {
        this.externalValue = externalValue;
    }

    @JsonValue
    public String getExternalValue() {
        return externalValue;
    }
}

