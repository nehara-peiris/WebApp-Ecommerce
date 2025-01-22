package lk.ijse.myclosetecom_web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "od_id")
    private Long odId;

    @ManyToOne
    @JoinColumn(name = "o_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Product product;

    private Integer qty;

    // Getters and setters
}
