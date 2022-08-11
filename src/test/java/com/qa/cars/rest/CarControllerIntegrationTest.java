package com.qa.cars.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cars.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:car-schema.sql","classpath:car-data.sql"},
        executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CarControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        Car testCar = new Car("Haas", 2018, "USA");
        RequestBuilder req = post("/createCar").content(this.mapper.writeValueAsString(testCar))
                .contentType(MediaType.APPLICATION_JSON);

        Car expectedCar = new Car(3, "Haas", 2018, "USA");

        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(expectedCar));
        this.mvc.perform(req).andExpect(status().isCreated()).andExpect(checkBody);
    }

    @Test
    void testGetById() throws Exception {
        Car testCar = new Car(2, "Alpine", 2019, "France");

        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testCar));
        this.mvc.perform(get("/get/2")).andExpect(status().isOk()).andExpect(checkBody);
    }

    @Test
    void testGetAll() throws Exception {
        List<Car> testCars = List.of(new Car(1, "Ferrari", 1950, "Italy"),
                new Car(2, "Alpine", 2019, "France"));

        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testCars));
        this.mvc.perform(get("/getAll")).andExpect(status().isOk()).andExpect(checkBody);

    }

    @Test
    void testUpdate() throws Exception {
        RequestBuilder req = patch("/update/1?name=AlfaRomeo&yearEst=2016&country=Switzerland");

        Car expectedCar = new Car(1, "AlfaRomeo", 2016, "Switzerland");
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(expectedCar));
        this.mvc.perform(req).andExpect(status().isOk()).andExpect(checkBody);
    }

    @Test
    void testRemover() throws Exception {
        Car testCar = new Car(1, "Ferrari", 1950, "Italy");
        ResultMatcher checkBody = content().json(this.mapper.writeValueAsString(testCar));
        this.mvc.perform(delete("/remove/1")).andExpect(status().isOk()).andExpect(checkBody);
    }

}
