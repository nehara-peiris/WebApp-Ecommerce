package lk.ijse.myclosetecom_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefundDTO {
    private Long refId;
    private OrderDTO order;
    private String refDate;
    private Double refAmount;
    private String reason;
    private String status;

    // Getters and setters
}
