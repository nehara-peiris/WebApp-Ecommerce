package lk.ijse.myclosetecom_web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int pId;

    private int catId;

    private String name;
    private Double price;

    private Integer qtyOnHand;

    private Set<Cart> cartItems;

    private Set<OrderDetail> orderDetails;

    public Product(int pId, int catId, String name, Double price, Integer qtyOnHand) {
        this.pId = pId;
        this.catId = catId;
        this.name = name;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
    }
}
