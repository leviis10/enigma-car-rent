package enigma.car_rent.service;

import enigma.car_rent.model.Brand;
import enigma.car_rent.utils.dto.BrandDTO;

import java.util.List;

public interface BrandService {
    Brand create(BrandDTO req);

    List<Brand> getAll();

    Brand getById(Integer id);

    Brand updateById(Integer id, BrandDTO req);

    void deleteById(Integer id);
}
