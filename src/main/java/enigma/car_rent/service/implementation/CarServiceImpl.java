package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.repository.CarRepository;
import enigma.car_rent.service.BrandService;
import enigma.car_rent.service.CarService;
import enigma.car_rent.utils.dto.CarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;

    @Override
    public Car create(CarDTO req) {
        Brand brand = brandService.getById(req.getBrandId());

        Car newCar = Car.builder()
                .name(req.getName())
                .brand(brand)
                .available(true)
                .price(req.getPrice())
                .build();

        return carRepository.save(newCar);
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
    public Car updateById(Integer id, CarDTO req) {
        Car car = getById(id);
        Brand brand = brandService.getById(req.getBrandId());

        car.setName(req.getName());
        car.setBrand(brand);
        car.setAvailable(req.getAvailable());
        car.setPrice(req.getPrice());

        return carRepository.save(car);
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }
}
