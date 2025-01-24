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
    private int uId;
    private String fullName;
    private String uName;
    private String email;
    private String password;
    private String role;
    private Cart cart;
    private Set<OrderDTO> orders;

    public UserDTO(String uName, String password, String role) {
        this.uName = uName;
        this.password = password;
        this.role = role;
    }

    public UserDTO(int uId, String fullName, String uName, String email, String password, String role) {
        this.uId = uId;
        this.fullName = fullName;
        this.uName = uName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
