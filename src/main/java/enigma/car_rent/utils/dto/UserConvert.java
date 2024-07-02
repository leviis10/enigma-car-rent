package enigma.car_rent.utils.dto;

import enigma.car_rent.model.User;

public class UserConvert {
    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .balance(user.getBalance())
                .build();
    }
}
