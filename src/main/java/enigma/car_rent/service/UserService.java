package enigma.car_rent.service;

import enigma.car_rent.model.User;
import enigma.car_rent.utils.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User create(UserDTO newUser);

    Page<User> getAll(Pageable pageable);

    User getById(Integer id);

    User updateById(Integer id, UserDTO updatedUser);

    void deleteById(Integer id);

    User topup(Integer id, Integer amount);
}
