package com.example.Exercice_api_car.dao;

import com.example.Exercice_api_car.model.Car;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarDao{
    private static Map<Integer, Car> cars = new HashMap<Integer, Car>();

    static {
        cars.put(0, new Car(0, "Clio", "Blanche"));
        cars.put(1, new Car(1, "Scénic", "Rouge"));
        cars.put(2, new Car(2, "Audi", "Noire"));

    }
    @Override
    public Map<Integer, Car> findAll() {
        return cars;
    }

    @Override
    public Car FindById(int id) {
        return cars.get(id);
    }

    @Override
    public void Save(Car car) {
        cars.put(car.getId(), car);
    }

    @Override
    public void Update(Car modifycar, int id) {
        Car car = cars.get(id);
        car.setBrandCar(modifycar.getBrandCar());
        car.setColorCar(modifycar.getColorCar());
    }

    @Override
    public void Delete(int id) {
        cars.remove(id);
    }
}
