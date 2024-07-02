package enigma.car_rent.service.implementation;

import enigma.car_rent.model.User;
import enigma.car_rent.repository.UserRepository;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.dto.UserConvert;
import enigma.car_rent.utils.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(UserDTO newUser) {
        return userRepository.save(User.builder()
                .name(newUser.getName())
                .balance(newUser.getBalance())
                .build());
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateById(Integer id, UserDTO updatedUser) {
        User user = getById(id);
        user.setName(updatedUser.getName());
        user.setBalance(updatedUser.getBalance());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User topup(Integer id, Integer amount) {
        User foundUser = getById(id);
        foundUser.setBalance(foundUser.getBalance() + amount);
        return updateById(id, UserConvert.toDTO(foundUser));
    }
}
