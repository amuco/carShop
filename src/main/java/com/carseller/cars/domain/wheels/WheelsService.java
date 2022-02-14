package com.carseller.cars.domain.wheels;

import org.w3c.dom.NodeList;

import java.util.List;

public interface WheelsService {

    void saveFromXmL(NodeList list);
    List<WheelsEntity> getAll();
}
