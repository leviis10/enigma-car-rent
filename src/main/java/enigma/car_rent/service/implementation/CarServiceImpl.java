package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Car;
import enigma.car_rent.repository.BrandRepository;
import enigma.car_rent.repository.CarRepository;
import enigma.car_rent.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Car create(Car req) {
        return carRepository.save(req);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car updateById( Car req,Integer id) {
        Car car = this.getById(id);
        car.setName(req.getName());
        car.setBrand(req.getBrand());
        car.setAvailable(req.getAvailable());
        car.setPrice(req.getPrice());

        return carRepository.save(car);
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }
}
