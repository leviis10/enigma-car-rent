package enigma.car_rent.utils.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "Name must no be blank")
    private String name;

    @Min(value = 0, message = "Balance cannot be a negative value")
    private Integer balance;
}
