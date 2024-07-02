package enigma.car_rent.controller;

import enigma.car_rent.model.Brand;
import enigma.car_rent.service.BrandService;
import enigma.car_rent.utils.dto.BrandDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brand create(@RequestBody BrandDTO request) {
        return brandService.create(request);
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable Integer id) {
        return brandService.getById(id);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Integer id, @RequestBody BrandDTO request) {
        return brandService.updateById(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        brandService.deleteById(id);
        return "Success Delete";
    }
}
