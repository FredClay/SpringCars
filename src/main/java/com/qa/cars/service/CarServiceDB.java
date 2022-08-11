package com.qa.cars.service;

import com.qa.cars.domain.Car;
import com.qa.cars.repos.CarRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CarServiceDB implements CarService{

    private CarRepo repo;

    public CarServiceDB(CarRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Car makeCar(Car car) {
        return this.repo.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return this.repo.findAll();
    }

    @Override
    public Car getById(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public List<Car> getByName(String name) {return this.repo.findCarsByNameJPQL(name);}

    @Override
    public List<Car> getByCountry(String country) {return this.repo.findCarsByCountryJPQL(country);}

    @Override
    public List<Car> getEnglishTeams() {return this.repo.findEnglishTeamsJPQL();}

    @Override
    public Car updateCar(int id, String name, Integer yearEst, String country) {
        Car activeCar = this.repo.findById(id).get();
        if (name != null && !name.isBlank()) activeCar.setName(name);
        if (yearEst != null) activeCar.setYearEst(yearEst);
        if (country != null) activeCar.setCountry(country);
        return this.repo.save(activeCar);
    }

    @Override
    public Car delete(int id) {
        Car toDelete = this.repo.findById(id).get();
        this.repo.deleteById(id);
        return toDelete;
    }
}
