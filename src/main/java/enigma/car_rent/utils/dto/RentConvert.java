package enigma.car_rent.utils.dto;

import enigma.car_rent.model.Rent;

public class RentConvert {
    public static RentDTO toDTO(Rent rent) {
        return RentDTO.builder()
                .completed(rent.getCompleted())
                .carId(rent.getCar().getId())
                .userId(rent.getUser().getId())
                .startedAt(rent.getStartedAt())
                .endsAt(rent.getEndsAt())
                .price(rent.getPrice())
                .build();
    }
}
