package enigma.car_rent.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "rents")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endsAt;

    private Integer price;
}
