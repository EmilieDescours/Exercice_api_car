package com.example.Exercice_api_car.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
//    @GeneratedValue
    private int id;

    private String brandCar;
    private String colorCar;

    public Car() {

    }

    public Car( int id , String brandCar, String colorCar) {
        this.id = id;
        this.brandCar = brandCar;
        this.colorCar = colorCar;
    }


    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }
    public String getColorCar() {
        return colorCar;
    }
    public void setColorCar(String colorCar){
        this.colorCar = colorCar;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brandCar='" + brandCar + '\'' +
                ", colorCar='" + colorCar + '\'' +
                '}';
    }
}
