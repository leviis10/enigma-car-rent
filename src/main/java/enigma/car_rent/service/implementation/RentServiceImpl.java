package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Car;
import enigma.car_rent.model.Rent;
import enigma.car_rent.model.User;
import enigma.car_rent.repository.RentRepository;
import enigma.car_rent.service.CarService;
import enigma.car_rent.service.RentService;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.dto.CarConvert;
import enigma.car_rent.utils.dto.RentConvert;
import enigma.car_rent.utils.dto.RentDTO;
import enigma.car_rent.utils.dto.UserConvert;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public Page<Rent> getAll(Pageable pageable) {
        return rentRepository.findAll(pageable);
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

    @Override
    public Rent carReturn(Integer id) {
        Rent foundRent = getById(id);
        foundRent.setCompleted(true);
        updateById(id, RentConvert.toDTO(foundRent));

        Car foundCar = carService.getById(foundRent.getCar().getId());
        foundCar.setAvailable(true);
        carService.updateById(foundCar.getId(), CarConvert.toDTO(foundCar));
        foundRent.setCar(foundCar);

        if (new Date().after(foundRent.getEndsAt())) {
            User foundUser = userService.getById(foundRent.getUser().getId());
            foundUser.setBalance(foundUser.getBalance() - (foundRent.getPrice() * 10 / 100));
            userService.updateById(foundUser.getId(), UserConvert.toDTO(foundUser));
            foundRent.setUser(foundUser);
        }

        return foundRent;
    }
}
