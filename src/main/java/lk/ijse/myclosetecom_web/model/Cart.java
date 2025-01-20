package lk.ijse.myclosetecom_web.model;

import jakarta.persistence.*;
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
    private Long ctId;

    @OneToOne
    @JoinColumn(name = "u_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "p_id", nullable = false)
    private Product product;

    private Integer qty;

    // Getters and setters
}


