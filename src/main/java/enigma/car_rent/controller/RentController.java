package enigma.car_rent.controller;


import enigma.car_rent.model.Rent;
import enigma.car_rent.service.RentService;
import enigma.car_rent.utils.dto.RentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rent create(@RequestBody RentDTO newRent) {
        return rentService.create(newRent);
    }

    @GetMapping
    public List<Rent> getAll() {
        return rentService.getAll();
    }

    @GetMapping("/{id}")
    public Rent getById(@PathVariable Integer id) {
        return rentService.getById(id);
    }

    @PutMapping("/{id}")
    public Rent updateById(@PathVariable Integer id, @RequestBody RentDTO updatedRent) {
        return rentService.updateById(id, updatedRent);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        rentService.deleteById(id);
    }

    @PutMapping("/{id}/return")
    public Rent carReturn(@PathVariable Integer id) {
        return rentService.carReturn(id);
    }
}
