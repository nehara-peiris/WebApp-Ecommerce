package lk.ijse.myclosetecom_web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    private Long ctId;

    private User user;

    private Product product;

    private Integer quantity;

}


