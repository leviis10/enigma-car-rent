package enigma.car_rent.controller;

import enigma.car_rent.service.CarService;
import enigma.car_rent.utils.dto.CarDTO;
import enigma.car_rent.utils.response.PageResponse;
import enigma.car_rent.utils.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    @Validated
    public ResponseEntity<?> create(@Valid @RequestBody CarDTO request) {
        return Response.renderJSON(
                carService.create(request),
                "New Car Record Created",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault Pageable pageable,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean available
    ) {
        return Response.renderJSON(new PageResponse<>(carService.getAll(pageable, name, available)));
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
