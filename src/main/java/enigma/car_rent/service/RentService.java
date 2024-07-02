package enigma.car_rent.service;

import enigma.car_rent.model.Rent;
import enigma.car_rent.utils.dto.RentDTO;

import java.util.List;

public interface RentService {
    Rent create(RentDTO newRent);

    List<Rent> getAll();

    Rent getById(Integer id);

    Rent updateById(Integer id, RentDTO updatedRent);

    void deleteById(Integer id);

    Rent carReturn(Integer id);
}
