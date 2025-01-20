package lk.ijse.myclosetecom_web.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long catId;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    // Getters and setters
}
