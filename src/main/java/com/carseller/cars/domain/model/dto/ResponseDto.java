package com.carseller.cars.domain.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {

    private String id;
    private String modelName;
    private String modelType;
    private String modelLine;
    private String from;
    private String to;
    private String engineType;
    private String enginePower;
    private String wheelsType;
    private String wheelsSize;
}
