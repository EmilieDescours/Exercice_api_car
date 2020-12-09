package com.example.Exercice_api_car.service;


import com.example.Exercice_api_car.model.Car;

import java.util.Map;

public interface CarService {

    public abstract void createCar(Car car);
    public abstract void updateCar(Integer id, Car car);
    public abstract void deleteCar(Integer id);
    public abstract Map< Integer, Car> getCar();
    Car FindById (Integer id);
}
