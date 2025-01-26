package lk.ijse.myclosetecom_web.dto;


import lk.ijse.myclosetecom_web.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDTO {
    private int ctId;

    private int pId;

    private String pName;

    private double pPrice;

    private Integer quantity;

    private double total;
}
