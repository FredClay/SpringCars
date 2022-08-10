package com.qa.cars.service;

import com.qa.cars.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceList implements CarService {

    private List<Car> cars;

    public CarServiceList() {
        super();
        this.cars = new ArrayList<>();
    }

    @Override
    public Car makeCar(Car car) {
        this.cars.add(car);
        return car;
    }

    @Override
    public List<Car> getAllCars () {
        return this.cars;
    }

    @Override
    public Car getById(int id) {
        return this.cars.get(id);
    }

    @Override
    public List<Car> getByName(String name) {
        List<Car> matches = new ArrayList<>();
        for (Car c : this.cars) {
            if (c.getName().equals(name)) matches.add(c);
        }
        return matches;
    }

    @Override
    public List<Car> getByCountry(String country) {
        List<Car> matches = new ArrayList<>();
        for (Car c : this.cars) {
            if (c.getCountry().equals(country)) matches.add(c);
        }
        return matches;
    }

    @Override
    public Car updateCar(int id, String name, Integer yearEst, String country){
        Car activeCar = this.cars.get(id);
        if (name != null && !name.isBlank()) activeCar.setName(name);
        if (yearEst != null) activeCar.setYearEst(yearEst);
        if (country != null) activeCar.setCountry(country);
        return activeCar;
    }

    @Override
    public Car delete(int id) {
        Car toRemove = this.cars.get(id);
        this.cars.remove(id);
        return toRemove;
    }


}
