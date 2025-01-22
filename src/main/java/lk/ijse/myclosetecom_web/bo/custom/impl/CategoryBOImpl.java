package lk.ijse.myclosetecom_web.bo.custom.impl;

import lk.ijse.myclosetecom_web.bo.custom.CategoryBO;
import lk.ijse.myclosetecom_web.dao.DAOFactory;
import lk.ijse.myclosetecom_web.dao.custom.CategoryDAO;
import lk.ijse.myclosetecom_web.dto.CategoryDTO;
import lk.ijse.myclosetecom_web.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryBOImpl implements CategoryBO {

    CategoryDAO categoryDAO = (CategoryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CATEGORY);
    @Override
    public List<CategoryDTO> getAllCategories() throws Exception {
        List<Category> categoryList = categoryDAO.getAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDTOList.add(new CategoryDTO(category.getCatId(), category.getName(), category.getDescription()));
        }
        return categoryDTOList;
    }

    @Override
    public boolean addCategory(CategoryDTO dto) throws Exception {
        Category category = new Category(dto.getCatId(), dto.getName(), dto.getDescription(), null);
        return categoryDAO.add(category);
    }

    @Override
    public boolean deleteCategory(CategoryDTO dto) throws Exception {
        Category category = new Category(dto.getCatId(), dto.getName(), dto.getDescription(), null);
        return categoryDAO.delete(category);
    }

    @Override
    public boolean updateCategory(CategoryDTO dto) throws Exception {
        Category category = new Category(dto.getCatId(), dto.getName(), dto.getDescription(), null);
        return categoryDAO.update(category);
    }

    @Override
    public CategoryDTO searchCategoryById(Object id) throws Exception {
        Category category = categoryDAO.searchById(id);
        if (category != null) {
            return new CategoryDTO(category.getCatId(), category.getName(), category.getDescription());
        }
        return null;
    }
}
