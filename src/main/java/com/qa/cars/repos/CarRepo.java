package com.qa.cars.repos;

import com.qa.cars.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

    @Query("SELECT c from Car c WHERE c.name = ?1")
    List<Car> findCarsByNameJPQL(String name);

    @Query("SELECT c from Car c WHERE c.country = ?1")
    List<Car> findCarsByCountryJPQL(String name);

    @Query("SELECT c from Car c WHERE c.country = 'England'")
    List<Car> findEnglishTeamsJPQL();
}
