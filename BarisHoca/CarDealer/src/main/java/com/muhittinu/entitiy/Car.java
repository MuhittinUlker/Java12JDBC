package com.muhittinu.entitiy;

public class Car {
    private int id;
    private String brand;
    private String carModel;
    private String modelYear;
    private int dealershipId;
    public Car() {
    }
    public Car(String brand, String carModel, String modelYear, int dealershipId) {
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealershipId = dealershipId;
    }
    public Car(int id, String brand, String carModel, String modelYear, int dealershipId) {
        this.id = id;
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealershipId = dealershipId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public String getModelYear() {
        return modelYear;
    }
    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }
    public int getDealershipId() {
        return dealershipId;
    }
    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", dealershipId=" + dealershipId +
                '}';
    }
}
