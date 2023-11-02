package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Car;
import com.muhittinu.utility.MyRepositoryFactory;

public class CarRepository extends MyRepositoryFactory<Car,Long> {
    public CarRepository() {
        super(Car.class);
    }
}
