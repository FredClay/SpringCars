package com.qa.cars.repos;

import com.qa.cars.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
}
