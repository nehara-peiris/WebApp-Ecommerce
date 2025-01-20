package lk.ijse.myclosetecom_web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "refund")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_id")
    private Long refId;

    @ManyToOne
    @JoinColumn(name = "o_id")
    private Order order;

    @Column(name = "ref_date")
    private String refDate;

    @Column(name = "ref_amount")
    private Double refAmount;

    private String reason;
    private String status;

    // Getters and setters
}
