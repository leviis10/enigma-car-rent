package enigma.car_rent.utils.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentDTO {
    private Boolean completed;
    private Integer carId;
    private Integer userId;
    private Date startedAt;
    private Date endsAt;
    private Integer price;
}
