package com.muhittinu.repository;

import com.muhittinu.repository.entitiy.Car;
import com.muhittinu.utility.MyRepositoryFactory;
import com.sun.xml.bind.v2.model.core.ID;

public class CarRepository extends MyRepositoryFactory<Car,ID> {
    public CarRepository() {
        super(Car.class);
    }
}
