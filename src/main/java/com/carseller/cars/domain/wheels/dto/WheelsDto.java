package com.carseller.cars.domain.wheels.dto;

import java.util.Objects;

public class WheelsDto {

    private String size;
    private String type;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WheelsDto{" +
                "size='" + size + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WheelsDto wheelsDto = (WheelsDto) o;
        return Objects.equals(size, wheelsDto.size) && Objects.equals(type, wheelsDto.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, type);
    }
}
