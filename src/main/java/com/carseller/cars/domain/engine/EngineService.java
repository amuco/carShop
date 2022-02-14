package com.carseller.cars.domain.engine;

import org.w3c.dom.NodeList;

import java.util.List;

public interface EngineService {

    void saveEngineFromXml(NodeList list);
    List<EngineEntity> getAll();
}
