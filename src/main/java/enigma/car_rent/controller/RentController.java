package enigma.car_rent.controller;


import enigma.car_rent.service.RentService;
import enigma.car_rent.utils.response.PageResponse;
import enigma.car_rent.utils.dto.RentDTO;
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
@RequestMapping("/rents")
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;

    @PostMapping
    @Validated
    public ResponseEntity<?> create(@Valid @RequestBody RentDTO newRent) {
        return Response.renderJSON(
                rentService.create(newRent),
                "New Rent Record Created",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        return Response.renderJSON(new PageResponse<>(rentService.getAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return Response.renderJSON(rentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody RentDTO updatedRent) {
        return Response.renderJSON(rentService.updateById(id, updatedRent));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        rentService.deleteById(id);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<?> carReturn(@PathVariable Integer id) {
        return Response.renderJSON(rentService.carReturn(id));
    }
}
