package com.example.Exercice_api_car;

import com.example.Exercice_api_car.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExerciceApiCarApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void shouldFindAllCars() {
        String body = this.restTemplate.getForObject("/cars", String.class);
        assertEquals("{\"0\":{\"id\":0,\"brandCar\":\"Clio\",\"colorCar\":\"Blanche\"},\"1\":{\"id\":1,\"brandCar\":\"Scénic\",\"colorCar\":\"Rouge\"},\"2\":{\"id\":2,\"brandCar\":\"Audi\",\"colorCar\":\"Noire\"},\"4\":{\"id\":4,\"brandCar\":\"Opel\",\"colorCar\":\"Rose pailleté\"}}", body);
    }
    @Test
    public void shouldAddNewCar() {
        Car newcar = new Car(4, "Opel", "caca d'oie");
        this.restTemplate.postForObject("/cars", newcar, String.class);
        String body = this.restTemplate.getForObject("/cars/4", String.class);
        assertEquals("{\"id\":4,\"brandCar\":\"Opel\",\"colorCar\":\"caca d'oie\"}", body);
    }
    @Test
    public void shouldModifyACar() {
        Car newcar = new Car(4, "Opel", "Rose pailleté");
        this.restTemplate.put("/cars/4", newcar, String.class);
        String body = this.restTemplate.getForObject("/cars/4", String.class);
        assertEquals("{\"id\":4,\"brandCar\":\"Opel\",\"colorCar\":\"Rose pailleté\"}", body);
    }
    @Test
    public void shouldDeleteACar() {
        this.restTemplate.delete("/cars/3");
        String body = this.restTemplate.getForObject("/cars/3", String.class);
        assertEquals(null, body);
    }

}
