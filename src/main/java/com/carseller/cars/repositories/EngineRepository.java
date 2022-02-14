package com.carseller.cars.repositories;

import com.carseller.cars.domain.engine.EngineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<EngineEntity,Long> {
}
