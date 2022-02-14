package com.carseller.cars.domain.model.converter;

import com.carseller.cars.domain.model.ModelEntity;
import com.carseller.cars.domain.model.dto.ModelDto;
import com.carseller.cars.domain.engine.converter.EngineConverter;
import com.carseller.cars.domain.engine.dto.EngineDto;
import com.carseller.cars.domain.model.dto.ResponseDto;
import com.carseller.cars.domain.wheels.converter.WheelsConverter;
import com.carseller.cars.domain.wheels.dto.WheelsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
@AllArgsConstructor
public class ModelConverter {


    private EngineConverter engineConverter;
    private WheelsConverter wheelsConverter;

    public List<ModelDto> extractCarModels(NodeList list) {
        List<ModelDto> modelDtosList =new ArrayList<>();
        for(int i = 0; i< list.getLength(); i++){
            Node node= list.item(i);
            if(node.getAttributes().getNamedItem("type")==null){
                continue;
            }
            ModelDto baseModel=convertToDto(node);
            Element element=(Element) node;
            NodeList subModels= element.getElementsByTagName("MODEL");
            extractEngine(node,baseModel);
            extractWheels(node,baseModel);
            List<ModelDto> subModelList=new ArrayList<>();
            for(int y=0;y<subModels.getLength();y++){
                Node subNode= subModels.item(y);
                ModelDto subModelDto=convertToDto(subNode);
                extractEngine(subNode,subModelDto);
                extractWheels(subNode,subModelDto);
                subModelList.add(subModelDto);
            }
            baseModel.setSubModels(subModelList);
            modelDtosList.add(baseModel);
        }
        return modelDtosList;
    }


    private ModelDto convertToDto(Node node){
        ModelDto modelDto =new ModelDto();
        if(node.getAttributes().getNamedItem("name")!=null){
            modelDto.setModelName(node.getAttributes().getNamedItem("name").getTextContent());
        }
        if(node.getAttributes().getNamedItem("type")!=null){
            modelDto.setModelType(node.getAttributes().getNamedItem("type").getTextContent());
        }
        if(node.getAttributes().getNamedItem("from")!=null){
            modelDto.setYearFrom(node.getAttributes().getNamedItem("from").getTextContent());
        }
        if(node.getAttributes().getNamedItem("to")!=null){
            modelDto.setYearTo(node.getAttributes().getNamedItem("to").getTextContent());
        }
        if(node.getAttributes().getNamedItem("line")!=null){
            modelDto.setLine(node.getAttributes().getNamedItem("line").getTextContent());
        }
        return modelDto;
    }

    private void extractEngine(Node node, ModelDto modelDto){
        Element element=(Element) node;
        Node engineNode=element.getElementsByTagName("ENGINE").item(0);
        EngineDto engineDto=engineConverter.getEngineType(engineNode);
        modelDto.setEngineDto(engineDto);
    }

    private void extractWheels(Node node, ModelDto modelDto){
        Element element=(Element) node;
        Node wheelsNode=element.getElementsByTagName("WHEELS").item(0);
        WheelsDto wheelsDto= wheelsConverter.extractWheels(wheelsNode);
        modelDto.setWheelsDto(wheelsDto);
    }

    public ModelEntity toEntity(ModelDto dto){
        ModelEntity entity=new ModelEntity();
        entity.setModelName(dto.getModelName());
        if(!Objects.isNull(dto.getModelType())) {
            entity.setModelType(dto.getModelType());
        }
        if(!Objects.isNull(dto.getYearFrom())) {
            entity.setYearFrom(dto.getYearFrom());
        }
        if(!Objects.isNull(dto.getYearTo())){
            entity.setYearTo(dto.getYearTo());
        }
        if(!Objects.isNull(dto.getLine())) {
            entity.setLine(dto.getLine());
        }
        if(dto.getSubModels()!= null) {
            toEntitySubmodels(dto, entity);
        }
        entity.setEngineEntity(engineConverter.toEntity(dto.getEngineDto()));
        entity.setWheelsEntity(wheelsConverter.toEntity(dto.getWheelsDto()));
        return entity;
    }

    public List<ModelEntity> toListEntity(List<ModelDto> dtoList){
        List<ModelEntity> entityList=new ArrayList<>();
        dtoList.forEach(dto-> entityList.add(toEntity(dto)));
        return entityList;
    }

    private void toEntitySubmodels(ModelDto dto,ModelEntity model){
        List<ModelEntity> list=new ArrayList<>();
        dto.getSubModels().forEach(subModel->{
            ModelEntity modelEntity=toEntity(subModel);
            modelEntity.setParent(model);
            list.add(modelEntity);
        });

        model.setSubModels(list);
    }

    public ResponseDto toDto(ModelEntity entity){
        ResponseDto response=new ResponseDto();
        if(!Objects.isNull(entity.getId().toString())) {
            response.setId(entity.getId().toString());
        }
        if(!Objects.isNull(entity.getModelName())) {
            response.setModelName(entity.getModelName());
        }
        if(!Objects.isNull(entity.getModelType())) {
            response.setModelType(entity.getModelType());
        }
        if(!Objects.isNull(entity.getYearFrom())) {
            response.setFrom(entity.getYearFrom());
        }
        if(!Objects.isNull(entity.getYearTo())){
            response.setTo(entity.getYearTo());
        }
        if(!Objects.isNull(entity.getLine())) {
            response.setModelLine(entity.getLine());
        }
        response.setEnginePower(entity.getEngineEntity().getPower().toString());
        response.setEngineType(entity.getEngineEntity().getType());
        response.setWheelsSize(entity.getWheelsEntity().getSize());
        response.setWheelsType(entity.getWheelsEntity().getType());

        return response;
    }


 }
