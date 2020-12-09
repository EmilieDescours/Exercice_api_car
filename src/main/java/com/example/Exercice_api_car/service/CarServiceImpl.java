package com.example.Exercice_api_car.service;

import com.example.Exercice_api_car.dao.CarDao;
import com.example.Exercice_api_car.dao.CarDaoImpl;
import com.example.Exercice_api_car.model.Car;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    private CarDao cardao;

    public CarServiceImpl(CarDao cardao) {
        this.cardao = cardao;
    }

    @Override
    public void createCar(Car car) {
        this.cardao.Save(car);
    }

    @Override
    public void updateCar(Integer id, Car modifycar) {
        this.cardao.Update(modifycar, id);
    }

    @Override
    public void deleteCar(Integer id) {
        this.cardao.Delete(id);
    }

    @Override
    public Map<Integer, Car> getCar() {
        return this.cardao.findAll();
    }

    @Override
    public Car FindById(Integer id) {
        return this.cardao.FindById(id);
    }
}
