package enigma.car_rent.service;

import enigma.car_rent.model.Car;
import enigma.car_rent.utils.dto.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Car create(CarDTO req);

    Page<Car> getAll(Pageable pageable, String name, Boolean available);

    Car getById(Integer id);

    Car updateById(Integer id, CarDTO req);

    void deleteById(Integer id);
}
