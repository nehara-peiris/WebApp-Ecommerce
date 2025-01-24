package lk.ijse.myclosetecom_web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetail {

    private Long odId;

    private Order order;

    private Product product;

    private Integer qty;

    private Double unitPrice;

    private Double totPrice;
}
