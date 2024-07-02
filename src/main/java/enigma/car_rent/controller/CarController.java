package enigma.car_rent.controller;

import enigma.car_rent.model.Car;
import enigma.car_rent.service.CarService;
import enigma.car_rent.utils.dto.CarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public Car create(@RequestBody CarDTO request) {
        return carService.create(request);
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id) {
        return carService.getById(id);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Integer id, @RequestBody CarDTO request) {
        return carService.updateById(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        carService.deleteById(id);
        return "Success Delete";
    }

}
