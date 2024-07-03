package enigma.car_rent.utils.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    @NotBlank(message = "Car name cannot be blank")
    private String name;

    @NotNull(message = "Brand ID cannot be blank")
    private Integer brandId;

    private Boolean available;

    @NotNull(message = "Car price cannot be blank")
    @Min(value = 0, message = "Car price cannot be negative")
    private Integer price;
}
