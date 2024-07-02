package enigma.car_rent.controller;

import enigma.car_rent.model.Car;
import enigma.car_rent.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public Car create(@RequestBody Car request){
        return carService.create(request);
    }

    @GetMapping
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id){
        return carService.getById(id);
    }

    @PutMapping("/{id}")
    public Car update(@RequestBody Car request,@PathVariable Integer id){
        return carService.updateById(request,id);
    }

    @DeleteMapping("/{id}")
    public String Delete(@PathVariable Integer id){
        carService.deleteById(id);
        return "Success Delete";
    }

}
