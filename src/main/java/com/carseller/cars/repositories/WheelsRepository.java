package com.carseller.cars.repositories;

import com.carseller.cars.domain.wheels.WheelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelsRepository extends JpaRepository<WheelsEntity,Long> {
}
