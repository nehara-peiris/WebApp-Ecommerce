package lk.ijse.myclosetecom_web.dto;

import lk.ijse.myclosetecom_web.entity.Product;
import lk.ijse.myclosetecom_web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long id;

    private int user;


    private int product;

    private Integer quantity;

    public CartItemDTO(int user, int product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }
}
