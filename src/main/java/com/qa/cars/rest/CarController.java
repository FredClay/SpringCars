package com.qa.cars.rest;

import com.qa.cars.domain.Car;
import com.qa.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        super();
        this.service = service;
    }

    @PostMapping("/createCar")
    public ResponseEntity<Car> makeCar(@RequestBody Car car) {
        return new ResponseEntity<Car>(this.service.makeCar(car), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<List<Car>>(this.service.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Car> getById(@PathVariable int id) {
        return new ResponseEntity<Car>(this.service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<Car>> getByName(@PathVariable String name) {
        return new ResponseEntity<List<Car>>(this.service.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/getByCountry/{country}")
    public ResponseEntity<List<Car>> getByCountry(@PathVariable String country) {
        return new ResponseEntity<List<Car>>(this.service.getByCountry(country), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @PathParam("name") String name, @PathParam("yearEst") Integer yearEst,
                          @PathParam("country") String country) {
        return new ResponseEntity<Car>(this.service.updateCar(id, name, yearEst, country), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Car> delete(@PathVariable int id) {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }

}
