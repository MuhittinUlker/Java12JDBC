package com.muhittinu;

import com.muhittinu.repository.CarRepository;
import com.muhittinu.repository.entitiy.Car;

public class Main {
    public static void main(String[] args) {
        Car car = Car.builder().brand("Honda").model("City").modelYear("2012").build();
        CarRepository carRepository = new CarRepository();
        carRepository.save(car);
    }
}