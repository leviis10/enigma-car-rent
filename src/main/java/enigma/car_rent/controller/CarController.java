package enigma.car_rent.controller;

import enigma.car_rent.model.Car;
import enigma.car_rent.service.CarService;
import enigma.car_rent.utils.dto.CarDTO;
import enigma.car_rent.utils.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CarDTO request) {
        return Response.renderJSON(
                carService.create(request),
                "New Car Record Created",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return Response.renderJSON(carService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CarDTO request) {
        return Response.renderJSON(carService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        carService.deleteById(id);
        return "Success Delete";
    }

}
