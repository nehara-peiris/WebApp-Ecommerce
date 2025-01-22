package lk.ijse.myclosetecom_web.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private Long oId;
    private UserDTO user;
    private String date;
    private Double total;
    private String status;
    private Set<OrderDetailDTO> orderDetails;
    private Set<RefundDTO> refunds;

    // Getters and setters
}
