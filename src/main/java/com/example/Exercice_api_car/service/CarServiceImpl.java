package com.example.Exercice_api_car.service;

import com.example.Exercice_api_car.dao.CarDao;
import com.example.Exercice_api_car.model.Car;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarDao cardao;

    public CarServiceImpl(CarDao cardao) {
        this.cardao = cardao;
    }

    @Override
    public void createCar(Car car) {
        this.cardao.save(car);
    }

    @Override
    public void updateCar(Integer id, Car modifycar) {
        this.cardao.save(modifycar);
    }

    @Override
    public void deleteCar(Integer id) {
        this.cardao.deleteById(id);
    }

    @Override
    public Map<Integer, Car> getCar() {
        Map<Integer, Car> listCar = new HashMap<>();
        List<Car> received_list = this.cardao.findAll();
        for(Car listed_car:received_list) {
            listCar.put(listed_car.getId(), listed_car);
        }
        return listCar;
    }

    @Override
    public Car FindById(Integer id) {
        return this.cardao.findById(id).orElse(null);
    }
}
