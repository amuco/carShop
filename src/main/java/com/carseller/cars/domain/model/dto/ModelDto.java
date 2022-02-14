package com.carseller.cars.domain.model.dto;

import com.carseller.cars.domain.engine.dto.EngineDto;
import com.carseller.cars.domain.wheels.dto.WheelsDto;

import java.util.List;

public class ModelDto {

    private String modelName;
    private String line;
    private String modelType;
    private String yearFrom;
    private String yearTo;
    private EngineDto engineDto;
    private WheelsDto wheelsDto;
    private List<ModelDto> subModels;


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(String yearFrom) {
        this.yearFrom = yearFrom;
    }

    public String getYearTo() {
        return yearTo;
    }

    public void setYearTo(String yearTo) {
        this.yearTo = yearTo;
    }

    public List<ModelDto> getSubModels() {
        return subModels;
    }

    public void setSubModels(List<ModelDto> subModels) {
        this.subModels = subModels;
    }

    public EngineDto getEngineDto() {
        return engineDto;
    }

    public void setEngineDto(EngineDto engineDto) {
        this.engineDto = engineDto;
    }

    public WheelsDto getWheelsDto() {
        return wheelsDto;
    }

    public void setWheelsDto(WheelsDto wheelsDto) {
        this.wheelsDto = wheelsDto;
    }

    @Override
    public String toString() {
        return "ModelDto{" +
                "modelName='" + modelName + '\'' +
                ", line='" + line + '\'' +
                ", modelType='" + modelType + '\'' +
                ", yearFrom='" + yearFrom + '\'' +
                ", yearTo='" + yearTo + '\'' +
                ", engineDto=" + engineDto +
                ", wheelsDto=" + wheelsDto +
                ", subModels=" + subModels +
                '}';
    }
}
