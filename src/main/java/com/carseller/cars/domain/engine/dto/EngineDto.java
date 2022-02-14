package com.carseller.cars.domain.engine.dto;

import java.util.Objects;

public class EngineDto {

    private int power;
    private String type;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EngineDto{" +
                "power=" + power +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineDto engineDto = (EngineDto) o;
        return power == engineDto.power && Objects.equals(type, engineDto.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, type);
    }
}
