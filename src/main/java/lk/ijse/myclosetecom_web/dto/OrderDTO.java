package lk.ijse.myclosetecom_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private int oId;
    private int user;
    private Date date;
    private Double total;
    private String status;
    private Set<OrderDetailDTO> orderDetails;

    public OrderDTO(int oId, int user, Date date, Double total, String status) {
        this.oId = oId;
        this.user = user;
        this.date = date;
        this.total = total;
        this.status = status;
    }
}
