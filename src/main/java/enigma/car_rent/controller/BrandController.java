package enigma.car_rent.controller;

import enigma.car_rent.service.BrandService;
import enigma.car_rent.utils.dto.BrandDTO;
import enigma.car_rent.utils.dto.PageResponse;
import enigma.car_rent.utils.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BrandDTO request) {
        return Response.renderJSON(
                brandService.create(request),
                "New Brand Record Created",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault Pageable pageable,
            @RequestParam(required = false) String name
    ) {
        return Response.renderJSON(new PageResponse<>(brandService.getAll(name, pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return Response.renderJSON(brandService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody BrandDTO request) {
        return Response.renderJSON(brandService.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        brandService.deleteById(id);
        return "Success Delete";
    }
}
