package enigma.car_rent.utils.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private String name;
    private Integer brandId;
    private Boolean available;
    private Integer price;
}
