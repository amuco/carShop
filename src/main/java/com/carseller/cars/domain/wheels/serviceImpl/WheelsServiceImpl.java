package com.carseller.cars.domain.wheels.serviceImpl;

import com.carseller.cars.domain.wheels.WheelsEntity;
import com.carseller.cars.domain.wheels.WheelsService;
import com.carseller.cars.domain.wheels.converter.WheelsConverter;
import com.carseller.cars.domain.wheels.dto.WheelsDto;
import com.carseller.cars.repositories.WheelsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class WheelsServiceImpl implements WheelsService {

    private WheelsRepository repository;
    private  WheelsConverter converter;

    public void saveFromXmL(NodeList list){
        log.info("Getting wheels from xml file");
       Set<WheelsDto> dtoSet= converter.extractWheelsFromFile(list);
        Set<WheelsEntity> wheelsEntitySet=converter.toEntitySet(dtoSet);
        repository.saveAll(wheelsEntitySet);
    }

    public List<WheelsEntity> getAll(){
        log.info("Return all wheels");
        return repository.findAll();
    }

}
