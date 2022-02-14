package com.carseller.cars.domain.engine;

import com.carseller.cars.domain.BaseEntity;
import com.carseller.cars.domain.model.ModelEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "engine")
@Getter@Setter
public class EngineEntity extends BaseEntity implements Serializable {

    private Integer power;
    private String type;

    @OneToMany(mappedBy = "engineEntity")
    private List<ModelEntity> models=new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineEntity engine = (EngineEntity) o;
        return Objects.equals(power, engine.power) && Objects.equals(type, engine.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, type);
    }
}
