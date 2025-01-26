package lk.ijse.myclosetecom_web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {

    private Long odId;

    private int order;

    private int product;

    private Integer qty;

    private Double unitPrice;

    private Double totPrice;

    public OrderDetail(int order, int product, Integer qty, Double unitPrice, Double totPrice) {
        this.order = order;
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totPrice = totPrice;
    }
}
