package lk.ijse.myclosetecom_web.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long pId;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    private String name;
    private Double price;

    @Column(name = "qtyOnHand")
    private Integer qtyOnHand;

    @Column(name = "img_url")
    private String imgUrl;

    @OneToMany(mappedBy = "product")
    private Set<Cart> cartItems;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;

    // Getters and setters
}
