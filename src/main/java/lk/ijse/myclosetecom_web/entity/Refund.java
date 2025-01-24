package lk.ijse.myclosetecom_web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Refund {
    private Long refId;

    private Order order;

    private String refDate;

    private Double refAmount;

    private String reason;

    private String status;
}
