package com.qa.cars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int yearEst;

    private String country;

    public Car(Integer id, String name, int yearEst, String country) {
        super();
        this.id = id;
        this.name = name;
        this.yearEst = yearEst;
        this.country = country;
    }

    public Car(String name, int yearEst, String country) {
        super();
        this.name = name;
        this.yearEst = yearEst;
        this.country = country;
    }

    public Car() {
        super();
        // Default Constructor.
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearEst() {
        return yearEst;
    }

    public void setYearEst(int yearEst) {
        this.yearEst = yearEst;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Car [name=" + this.name + ", yearEst= " + this.yearEst + ", country=" + this.country + "]";
    }

}
