package com.carseller.cars.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.carseller.cars.domain"})
@EnableJpaRepositories(basePackages = {"com.carseller.cars.repositories"})
public class DataBaseConfiguration {
}
