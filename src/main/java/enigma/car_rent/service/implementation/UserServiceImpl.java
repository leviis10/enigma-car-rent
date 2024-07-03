package enigma.car_rent.service.implementation;

import enigma.car_rent.model.User;
import enigma.car_rent.repository.UserRepository;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.dto.UserConvert;
import enigma.car_rent.utils.dto.UserDTO;
import enigma.car_rent.utils.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(UserDTO newUser) {
        return userRepository.save(User.builder()
                .name(newUser.getName())
                .balance(newUser.getBalance() > 0 ? newUser.getBalance() : 0)
                .build());
    }

    @Override
    public Page<User> getAll(Pageable pageable, String name) {
        Specification<User> spec = UserSpecification.getSpecification(name);
        return userRepository.findAll(spec, pageable);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
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
