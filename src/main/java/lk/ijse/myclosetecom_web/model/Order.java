package lk.ijse.myclosetecom_web.model;

import jakarta.persistence.*;

import java.util.Set;

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
