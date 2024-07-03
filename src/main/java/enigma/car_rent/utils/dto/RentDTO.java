package enigma.car_rent.utils.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentDTO {
    private Boolean completed;

    @NotNull(message = "Car ID cannot be null")
    private Integer carId;

    @NotNull(message = "User ID cannot be null")
    private Integer userId;

    private Date startedAt;

    @NotNull(message = "Rent end date cannot be null")
    private Date endsAt;

    private Integer price;
}
