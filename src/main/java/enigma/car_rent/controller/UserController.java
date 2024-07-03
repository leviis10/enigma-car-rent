package enigma.car_rent.controller;

import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.dto.PageResponse;
import enigma.car_rent.utils.dto.Response;
import enigma.car_rent.utils.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDTO newUser) {
        return Response.renderJSON(
                userService.create(newUser),
                "New User Created",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        return Response.renderJSON(new PageResponse<>(userService.getAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return Response.renderJSON(userService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody UserDTO updatedUser) {
        return Response.renderJSON(userService.updateById(id, updatedUser), "Updated");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}/topup")
    public ResponseEntity<?> topup(@PathVariable Integer id, @RequestParam Integer amount) {
        return Response.renderJSON(userService.topup(id, amount), "Success Top Up");
    }
}
