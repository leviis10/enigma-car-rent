package enigma.car_rent.service;

import enigma.car_rent.model.Rent;
import enigma.car_rent.utils.dto.RentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentService {
    Rent create(RentDTO newRent);

    Page<Rent> getAll(Pageable pageable);

    Rent getById(Integer id);

    Rent updateById(Integer id, RentDTO updatedRent);

    void deleteById(Integer id);

    Rent carReturn(Integer id);
}
