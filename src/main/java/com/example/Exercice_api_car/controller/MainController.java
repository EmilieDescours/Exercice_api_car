package com.example.Exercice_api_car.controller;

import java.util.Map;

import com.example.Exercice_api_car.model.Car;
import com.example.Exercice_api_car.dao.CarDao;
import com.example.Exercice_api_car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }




    @GetMapping(value = "/cars")
    @ResponseBody
    public Map<Integer, Car> getCars() {
        return this.carService.getCar();
    }

    @GetMapping(value = "/cars/{id}")
    @ResponseBody
    public Car getCar(@PathVariable("id") int id) {
        return this.carService.FindById(id);

    }

    @PostMapping(path = "/cars", consumes = "application/json")
    @ResponseBody
    public void addCar(@RequestBody Car car) {
         this.carService.createCar(car);

    }

    //@RequestMapping(value = {"/cars2"}, method = RequestMethod.POST)
//@ResponseBody
//ArrayList<Car> addCar2(@RequestBody String body) {
//    JSONObject json = new JSONObject(body);
//    Car car = new Car(28, json.getString("brandCar"), json.getString("colorCar"));
//    cars.add(car);
//    return this.getCars();
//}
    @PutMapping(path = "/cars/{id}", consumes = "application/json")
    @ResponseBody
    public void modifyCar(@RequestBody Car modifycar, @PathVariable("id") int id) {
       this.carService.updateCar(id, modifycar);
    }

    @DeleteMapping(path = "/cars/{id}", consumes = "application/json")
    @ResponseBody
    public void deleteCar(@PathVariable("id") int id) {
        this.carService.deleteCar(id);
    }
}
