package com.carseller.cars.controller;


import com.carseller.cars.domain.model.ModelService;
import com.carseller.cars.domain.model.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarModelController {

    @Autowired
    ModelService service;

    @GetMapping(path = "/cars")
    public List<ResponseDto> getAllModels(){
        return service.getAllCarModels();
    }

    @GetMapping(path = "cars/{name}/model")
    public List<ResponseDto> getByMake(@PathVariable String name){
        List<ResponseDto> responseDtos=new ArrayList<>();
        responseDtos.add(service.getByMake(name));
        return responseDtos;
    }

    @GetMapping(path = "cars/{id}")
    public ResponseDto findByID(@PathVariable Long id){
        return service.findById(id);
    }


}
