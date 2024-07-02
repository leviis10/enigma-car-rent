package enigma.car_rent.service;

import enigma.car_rent.model.Car;
import enigma.car_rent.utils.dto.CarDTO;

import java.util.List;

public interface CarService {
    Car create(CarDTO req);
    List<Car> getAll();
    Car getById(Integer id);
    Car updateById(Integer id, CarDTO req);
    void deleteById(Integer id);
}
