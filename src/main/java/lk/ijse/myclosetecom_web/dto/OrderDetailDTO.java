package lk.ijse.myclosetecom_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
    private Long odId;
    private OrderDTO order;
    private ProductDTO product;
    private Integer qty;

    // Getters and setters
}
