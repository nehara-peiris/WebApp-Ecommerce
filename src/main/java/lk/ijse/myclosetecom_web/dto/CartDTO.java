package lk.ijse.myclosetecom_web.dto;


import lk.ijse.myclosetecom_web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDTO {
    private Long ctId;
    private User user;
    private ProductDTO product;
    private Integer qty;
}
