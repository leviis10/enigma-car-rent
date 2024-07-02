package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Car;
import enigma.car_rent.model.Rent;
import enigma.car_rent.model.User;
import enigma.car_rent.repository.RentRepository;
import enigma.car_rent.service.CarService;
import enigma.car_rent.service.RentService;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.dto.CarConvert;
import enigma.car_rent.utils.dto.RentDTO;
import enigma.car_rent.utils.dto.UserConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    private final CarService carService;
    private final UserService userService;

    @Override
    public Rent create(RentDTO newRentDTO) {
        Car car = carService.getById(newRentDTO.getCarId());
        car.setAvailable(false);
        carService.updateById(car.getId(), CarConvert.toDTO(car));

        User user = userService.getById(newRentDTO.getUserId());
        user.setBalance(user.getBalance() - car.getPrice());
        userService.updateById(user.getId(), UserConvert.toDTO(user));

        Rent newRent = Rent.builder()
                .completed(false)
                .car(car)
                .user(user)
                .startedAt(new Date())
                .endsAt(newRentDTO.getEndsAt())
                .price(car.getPrice())
                .build();

        return rentRepository.save(newRent);
    }

    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getById(Integer id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public Rent updateById(Integer id, RentDTO updatedRentDTO) {
        Rent foundRent = getById(id);
        Car car = carService.getById(updatedRentDTO.getCarId());
        User user = userService.getById(updatedRentDTO.getUserId());

        foundRent.setCompleted(updatedRentDTO.getCompleted());
        foundRent.setCar(car);
        foundRent.setUser(user);
        foundRent.setStartedAt(updatedRentDTO.getStartedAt());
        foundRent.setEndsAt(updatedRentDTO.getEndsAt());
        foundRent.setPrice(updatedRentDTO.getPrice());

        return rentRepository.save(foundRent);
    }

    @Override
    public void deleteById(Integer id) {
        rentRepository.deleteById(id);
    }
}
