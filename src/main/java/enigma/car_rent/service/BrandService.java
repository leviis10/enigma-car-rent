package enigma.car_rent.service;

import enigma.car_rent.model.Brand;
import enigma.car_rent.utils.dto.BrandDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {
    Brand create(BrandDTO req);

    Page<Brand> getAll(String name, Pageable pageable);

    Brand getById(Integer id);

    Brand updateById(Integer id, BrandDTO req);

    void deleteById(Integer id);
}
