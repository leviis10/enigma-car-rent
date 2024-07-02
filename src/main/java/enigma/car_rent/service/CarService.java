package enigma.car_rent.service;

import enigma.car_rent.model.Car;

import java.util.List;

public interface CarService {
    Car create(Car req);
    List<Car> getAll();
    Car getById(Integer id);
    Car updateById(Car req,Integer id);
    void deleteById(Integer id);
}
