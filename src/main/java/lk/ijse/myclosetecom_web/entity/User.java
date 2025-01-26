package lk.ijse.myclosetecom_web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int uId;
    private String fullName;
    private String uName;
    private String email;
    private String password;
    private String role;
    private CartItem cart;
    private Set<Order> orders;

    public User(String uName, String password, String role) {
        this.uName = uName;
        this.password = password;
        this.role = role;
    }

    public User(int uId, String fullName, String uName, String email, String password, String role) {
        this.uId = uId;
        this.fullName = fullName;
        this.uName = uName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
