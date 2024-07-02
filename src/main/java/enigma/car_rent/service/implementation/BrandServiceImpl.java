package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.repository.BrandRepository;
import enigma.car_rent.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public Brand create(Brand req) {
        return brandRepository.save(req);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand updateById(Integer id, Brand req) {
        Brand brand = this.getById(id);
        brand.setName(req.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandRepository.deleteById(id);
    }
}
