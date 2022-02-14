package com.carseller.cars.domain.engine.serviceImpl;

import com.carseller.cars.domain.engine.EngineEntity;
import com.carseller.cars.domain.engine.EngineService;
import com.carseller.cars.domain.engine.converter.EngineConverter;
import com.carseller.cars.domain.engine.dto.EngineDto;
import com.carseller.cars.repositories.EngineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EngineServiceImpl implements EngineService {


    private EngineRepository repository;
    private EngineConverter converter;

    public void saveEngineFromXml(NodeList list){
        Set<EngineDto> dtoSet=converter.getEngineTypesFromFile(list);
        Set<EngineEntity> entitySet=converter.toEntitySet(dtoSet);
        repository.saveAll(entitySet);
    }

    public List<EngineEntity> getAll(){
        return repository.findAll();
    }
}
