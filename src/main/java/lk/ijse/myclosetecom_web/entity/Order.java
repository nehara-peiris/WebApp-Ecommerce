package lk.ijse.myclosetecom_web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Long oId;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    private String date;
    private Double total;
    private String status;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order")
    private Set<Refund> refunds;

    // Getters and setters
}
