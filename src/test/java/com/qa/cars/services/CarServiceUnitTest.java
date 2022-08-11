package com.qa.cars.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.qa.cars.domain.Car;
import com.qa.cars.repos.CarRepo;
import com.qa.cars.service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class CarServiceUnitTest {

    @Autowired
    private CarService service;

    @MockBean
    private CarRepo repo;

    @Test
    void testUpdate() {
        final int id = 1;
        final String newName = "Haas";
        final int newYear = 2018;
        final String newCountry = "USA";

        Car expected = new Car(id, newName, newYear, newCountry);

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Car(id, "Ferrari", 1950, "Italy")));
        Mockito.when(this.repo.save(new Car(id, newName, newYear, newCountry)))
                .thenReturn(new Car(id, newName, newYear, newCountry));

        Car actual = this.service.updateCar(id, newName, newYear, newCountry);

        // assertEquals calls the first obj's .equals() method and passes it the second object.
        assertEquals(expected, actual);
    }

    @Test
    void testNullParamUpdate() {
        final int id = 2;
        final String baseName = "Aston Martin";
        final int newYear = 1980;
        final String baseCountry = "England";

        Car expected = new Car(id, baseName, newYear, baseCountry);

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Car(id, baseName, 1975, baseCountry)));
        Mockito.when(this.repo.save(new Car(id, baseName, newYear, baseCountry)))
                .thenReturn(new Car(id, baseName, newYear, baseCountry));

        Car actual = this.service.updateCar(id, null, newYear, null);

        assertEquals(expected, actual);
    }

}
