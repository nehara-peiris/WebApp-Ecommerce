package lk.ijse.myclosetecom_web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {
    private int catId;
    private String name;
    private String description;
    private Set<ProductDTO> products;

    public CategoryDTO(int catId, String name, String description) {
        this.catId = catId;
        this.name = name;
        this.description = description;
    }
}
