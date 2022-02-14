package com.carseller.cars.domain.wheels.converter;

import com.carseller.cars.domain.wheels.WheelsEntity;
import com.carseller.cars.domain.wheels.dto.WheelsDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
@NoArgsConstructor
public class WheelsConverter {

    public Set<WheelsDto> extractWheelsFromFile(NodeList wheelList) {
        Set<WheelsDto> wheelsDtoSet=new HashSet<>();
        for(int i = 0; i< wheelList.getLength(); i++){
            Node node= wheelList.item(i);
            WheelsDto wheelsDto=new WheelsDto();
            wheelsDto.setSize(node.getAttributes().getNamedItem("size").getTextContent());
            wheelsDto.setType(node.getAttributes().getNamedItem("type").getTextContent());
            if(!wheelsDtoSet.contains(wheelsDto)){
                wheelsDtoSet.add(wheelsDto);
            }
        }
        return wheelsDtoSet;
    }

    public WheelsDto extractWheels(Node wheels) {
            WheelsDto wheelsDto=new WheelsDto();
            wheelsDto.setSize(wheels.getAttributes().getNamedItem("size").getTextContent());
            wheelsDto.setType(wheels.getAttributes().getNamedItem("type").getTextContent());
        return wheelsDto;
    }

    public WheelsEntity toEntity(WheelsDto dto){
        WheelsEntity wheels=new WheelsEntity();
        if(!Objects.isNull(dto.getType())) {
            wheels.setType(dto.getType());
        }
        if(!Objects.isNull(dto.getSize())){
        wheels.setSize(dto.getSize());
        }

        return wheels;
    }

    public Set<WheelsEntity> toEntitySet(Set<WheelsDto> dtoSet){
        Set<WheelsEntity> wheelsEntitySet=new HashSet<>();
        dtoSet.forEach(dto-> wheelsEntitySet.add(toEntity(dto)));
        return wheelsEntitySet;
    }

    public WheelsDto toDto(WheelsEntity entity){
        WheelsDto dto=new WheelsDto();
        dto.setSize(entity.getSize());
        dto.setType(entity.getType());
        return dto;
    }
}
