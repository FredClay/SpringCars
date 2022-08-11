package com.qa.cars.service;

import com.qa.cars.domain.Car;

import java.util.List;

public interface CarService {

    Car makeCar(Car car);

    List<Car> getAllCars();

    Car getById(int id);

    List<Car> getByName(String name);

    List<Car> getByCountry(String name);

    List<Car> getEnglishTeams();

    Car updateCar(int id, String name, Integer yearEst, String country);

    public Car delete(int id);

}
