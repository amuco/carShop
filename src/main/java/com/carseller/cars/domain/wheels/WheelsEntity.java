package com.carseller.cars.domain.wheels;

import com.carseller.cars.domain.BaseEntity;
import com.carseller.cars.domain.model.ModelEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "wheels")
@NoArgsConstructor
@Getter@Setter
public class WheelsEntity extends BaseEntity implements Serializable {

    private String size;
    private String type;

    @OneToMany(mappedBy = "wheelsEntity")
    private List<ModelEntity> models=new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WheelsEntity wheels = (WheelsEntity) o;
        return Objects.equals(size, wheels.size) && Objects.equals(type, wheels.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, type);
    }
}
