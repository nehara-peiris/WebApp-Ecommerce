package lk.ijse.myclosetecom_web.entity;

import jakarta.persistence.*;
import lk.ijse.myclosetecom_web.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    private int catId;
    private String name;
    private String description;
    private Set<ProductDTO> products;

    public Category(int catId, String name, String description) {
        this.catId = catId;
        this.name = name;
        this.description = description;
    }
}
