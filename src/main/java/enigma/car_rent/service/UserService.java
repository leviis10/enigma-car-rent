package enigma.car_rent.service;

import enigma.car_rent.model.User;
import enigma.car_rent.utils.dto.UserDTO;

import java.util.List;

public interface UserService {
    User create(UserDTO newUser);

    List<User> getAll();

    User getById(Integer id);

    User updateById(Integer id, UserDTO updatedUser);

    void deleteById(Integer id);
}
