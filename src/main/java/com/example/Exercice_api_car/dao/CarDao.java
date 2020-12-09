package com.example.Exercice_api_car.dao;

import com.example.Exercice_api_car.model.Car;

import java.util.Map;

public interface CarDao {

    public Map<Integer, Car> findAll();
    public Car FindById(int id);
    public void Save(Car car);
    public void Update(Car car, int id);
    public void Delete (int id);


}
