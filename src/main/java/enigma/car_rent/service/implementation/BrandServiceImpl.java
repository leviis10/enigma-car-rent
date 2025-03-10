package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.repository.BrandRepository;
import enigma.car_rent.service.BrandService;
import enigma.car_rent.utils.dto.BrandDTO;
import enigma.car_rent.utils.specification.BrandSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public Brand create(BrandDTO req) {
        return brandRepository.save(Brand.builder()
                .name(req.getName())
                .build());
    }

    @Override
    public Page<Brand> getAll(String name, Pageable pageable) {
        Specification<Brand> spec = BrandSpecification.getSpecification(name);
        return brandRepository.findAll(spec, pageable);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    @Override
    public Brand updateById(Integer id, BrandDTO req) {
        Brand brand = this.getById(id);
        brand.setName(req.getName());
        return brandRepository.save(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandRepository.deleteById(id);
    }
}
