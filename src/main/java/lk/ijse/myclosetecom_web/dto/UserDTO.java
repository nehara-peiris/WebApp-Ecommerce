package lk.ijse.myclosetecom_web.dto;

import lk.ijse.myclosetecom_web.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long uId;
    private String fullName;
    private String uName;
    private String email;
    private String password;
    private String role;
    private Cart cart;
    private Set<OrderDTO> orders;

    // Getters and setters
}
