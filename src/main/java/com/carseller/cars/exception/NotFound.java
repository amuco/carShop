package com.carseller.cars.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotFound {
    NOT_FOUND_MODEL("Car model not found"),
    NOT_FOUND_ENGINE("Engine not found"),
    NOT_FOUND_WHEELS("Wheels not found");
    private String message;
}
