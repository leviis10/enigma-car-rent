package enigma.car_rent.utils.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    @NotBlank(message = "Brand name cannot be blank")
    private String name;
}
