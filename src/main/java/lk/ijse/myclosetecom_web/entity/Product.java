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
