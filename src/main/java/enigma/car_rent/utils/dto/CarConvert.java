package enigma.car_rent.utils.dto;

import enigma.car_rent.model.Car;

public class CarConvert {
    public static CarDTO toDTO(Car car) {
        return CarDTO.builder()
                .name(car.getName())
                .brandId(car.getBrand().getId())
                .available(car.getAvailable())
                .price(car.getPrice())
                .build();
    }
}
