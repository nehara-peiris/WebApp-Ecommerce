package lk.ijse.myclosetecom_web.bo.custom;

import lk.ijse.myclosetecom_web.bo.SuperBO;
import lk.ijse.myclosetecom_web.dto.CategoryDTO;


import java.util.List;

public interface CategoryBO extends SuperBO {
    List<CategoryDTO> getAllCategories() throws Exception;

    boolean addCategory(CategoryDTO dto) throws Exception;

    boolean deleteCategory(String id) throws Exception;

    boolean updateCategory(CategoryDTO dto) throws Exception;

    CategoryDTO searchCategoryById(Object id) throws Exception;
}
