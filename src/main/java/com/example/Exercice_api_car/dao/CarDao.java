package com.example.Exercice_api_car.dao;

import com.example.Exercice_api_car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface CarDao extends JpaRepository <Car, Integer> {

}
