package com.carseller.cars.repositories;

import com.carseller.cars.domain.model.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {

    Optional<ModelEntity> findByModelName(String modelName);

    Optional<ModelEntity>  findById(Long id);
}
