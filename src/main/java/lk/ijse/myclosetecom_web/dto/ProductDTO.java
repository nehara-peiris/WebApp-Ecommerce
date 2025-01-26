package lk.ijse.myclosetecom_web.dto;

import lk.ijse.myclosetecom_web.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private int pId;
    private int category;
    private String name;
    private Double price;
    private Integer qtyOnHand;
    private String imgUrl;
    private Set<CartItem> cartItems;
    private Set<OrderDetailDTO> orderDetails;

    public ProductDTO(int pId, int category, String name, Double price, Integer qtyOnHand) {
        this.pId = pId;
        this.category = category;
        this.name = name;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
    }

    public ProductDTO(int pId, int category, String name, Double price, Integer qtyOnHand, String imgUrl) {
        this.pId = pId;
        this.category = category;
        this.name = name;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
        this.imgUrl = imgUrl;
    }
}
