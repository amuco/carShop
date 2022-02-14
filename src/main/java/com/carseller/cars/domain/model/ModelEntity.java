package com.carseller.cars.domain.model;


import com.carseller.cars.domain.BaseEntity;
import com.carseller.cars.domain.engine.EngineEntity;
import com.carseller.cars.domain.wheels.WheelsEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "model")
@Getter@Setter
public class ModelEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;


    private String modelName;
    private String line;
    private String modelType;
    private String yearFrom;
    private String yearTo;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ModelEntity parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ModelEntity> subModels=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "engine_id",nullable = false )
    private EngineEntity engineEntity;


    @ManyToOne
    @JoinColumn(name = "wheels_id",nullable = false)
    private WheelsEntity wheelsEntity;

}
