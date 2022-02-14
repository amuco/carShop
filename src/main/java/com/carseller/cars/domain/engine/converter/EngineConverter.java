package com.carseller.cars.domain.engine.converter;

import com.carseller.cars.domain.engine.EngineEntity;
import com.carseller.cars.domain.engine.dto.EngineDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashSet;
import java.util.Set;

@Component
@NoArgsConstructor
public class EngineConverter {

    public Set<EngineDto> getEngineTypesFromFile(NodeList engineList){
            Set<EngineDto> engineDtoSet=new HashSet<>();
            for(int i = 0; i< engineList.getLength(); i++){
                EngineDto engineDto=new EngineDto();
                Node engineNode= engineList.item(i);
                engineDto.setPower(Integer.parseInt(engineNode.getAttributes().getNamedItem("power").getTextContent()));
                engineDto.setType(engineNode.getAttributes().getNamedItem("type").getTextContent());
                if(!engineDtoSet.contains(engineDto)){
                    engineDtoSet.add(engineDto);
                }
            }
            return engineDtoSet;
    }

    public EngineDto getEngineType(Node engine){
            EngineDto engineDto=new EngineDto();
            engineDto.setPower(Integer.parseInt(engine.getAttributes().getNamedItem("power").getTextContent()));
            engineDto.setType(engine.getAttributes().getNamedItem("type").getTextContent());

        return engineDto;
    }

    public EngineEntity toEntity(EngineDto dto){
        EngineEntity engine=new EngineEntity();
        engine.setPower(dto.getPower());
        engine.setType(dto.getType());
        return engine;
    }

    public Set<EngineEntity> toEntitySet(Set<EngineDto> dtoSet){
        Set<EngineEntity> entitySet=new HashSet<>();
        dtoSet.forEach(dto-> entitySet.add(toEntity(dto)));
        return entitySet;
    }

    public EngineDto toDto(EngineEntity entity){
        EngineDto dto=new EngineDto();
        dto.setPower(entity.getPower());
        dto.setType(entity.getType());
        return dto;
    }

}
