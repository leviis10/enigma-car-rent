package enigma.car_rent.service;

import enigma.car_rent.model.Brand;

import java.util.List;

public interface BrandService {
    Brand create(Brand req);
    List<Brand> getAll();
    Brand getById(Integer id);
    Brand updateById(Integer id, Brand req);
    void deleteById(Integer id);
}
