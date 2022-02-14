package com.carseller.cars.domain.model.service;

import com.carseller.cars.domain.engine.EngineEntity;
import com.carseller.cars.domain.engine.EngineService;
import com.carseller.cars.domain.model.ModelEntity;
import com.carseller.cars.domain.model.ModelService;
import com.carseller.cars.domain.model.converter.ModelConverter;
import com.carseller.cars.domain.model.dto.ModelDto;
import com.carseller.cars.domain.model.dto.ResponseDto;
import com.carseller.cars.domain.wheels.WheelsService;
import com.carseller.cars.exception.NotFound;
import com.carseller.cars.exception.NotFoundException;
import com.carseller.cars.repositories.ModelRepository;
import com.carseller.cars.domain.wheels.WheelsEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private ModelRepository repository;
    private ModelConverter converter;
    private EngineService engineService;
    private WheelsService wheelsService;

    @Override
    public void saveModelFromXml(NodeList list){
        log.info("Inserting car models from xml file");
        List<ModelDto> modelDtoList=converter.extractCarModels(list);
        List<ModelEntity> entityList=converter.toListEntity(modelDtoList);
        entityList.forEach(model -> {
            setWheelType(model);
            setEngineType(model);
            model.getSubModels().forEach(subModel->{
                setEngineType(subModel);
                setWheelType(subModel);
            });

        });
        repository.saveAll(entityList);
    }

    @Override
    public List<ResponseDto> getAllCarModels(){
        List<ModelEntity> modelEntityList=repository.findAll();
        return modelEntityList.stream().map(model -> converter.toDto(model)).collect(Collectors.toList());
    }

    @Override
    public ResponseDto getByMake(String name){
        ModelEntity model= repository.findByModelName(name).orElseThrow(()->new NotFoundException(NotFound.NOT_FOUND_MODEL));
        return converter.toDto(model);
    }

    @Override
    public ResponseDto findById(Long id){
        ModelEntity model=repository.findById(id).orElseThrow(()->new NotFoundException(NotFound.NOT_FOUND_MODEL));
        return converter.toDto(model);
    }
    private void setEngineType(ModelEntity model){
        log.info("Associating engine with car models");
        List<EngineEntity> engineEntityList=engineService.getAll();
        EngineEntity engine=engineEntityList.stream()
                .filter(engineEntity -> engineEntity.equals(model.getEngineEntity())).findFirst()
                .orElseThrow(()->new NotFoundException(NotFound.NOT_FOUND_ENGINE));
        model.setEngineEntity(engine);
    }

    private void setWheelType(ModelEntity model){
        log.info("Associating wheels with car models");
        List<WheelsEntity>  wheelsEntityList=wheelsService.getAll();
        WheelsEntity wheels=wheelsEntityList.stream().filter(wheelsEntity -> wheelsEntity.equals(model.getWheelsEntity()))
                .findFirst()
                .orElseThrow(()->new NotFoundException(NotFound.NOT_FOUND_MODEL));
        model.setWheelsEntity(wheels);
    }



}
