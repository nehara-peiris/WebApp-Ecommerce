package lk.ijse.myclosetecom_web.dto;

import lk.ijse.myclosetecom_web.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Long pId;
    private CategoryDTO category;
    private String name;
    private Double price;
    private Integer qtyOnHand;
    private String imgUrl;
    private Set<Cart> cartItems;
    private Set<OrderDetailDTO> orderDetails;

    // Getters and setters
}
