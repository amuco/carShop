package com.carseller.cars.domain.model;

import com.carseller.cars.domain.model.dto.ResponseDto;
import org.w3c.dom.NodeList;

import java.util.List;

public interface ModelService {
    void saveModelFromXml(NodeList list);
    List<ResponseDto> getAllCarModels();
    ResponseDto getByMake(String name);
    ResponseDto findById(Long Id);
}
