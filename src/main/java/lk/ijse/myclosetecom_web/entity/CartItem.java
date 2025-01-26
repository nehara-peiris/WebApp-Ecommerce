package lk.ijse.myclosetecom_web.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem {

    private Long id;

    private int user;

    private int product;

    private Integer quantity;
}
