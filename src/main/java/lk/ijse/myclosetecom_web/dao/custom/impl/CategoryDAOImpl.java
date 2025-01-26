package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.SQLUtil;
import lk.ijse.myclosetecom_web.dao.custom.CategoryDAO;
import lk.ijse.myclosetecom_web.db.DBConnection;
import lk.ijse.myclosetecom_web.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> getAll() throws Exception {
        String sql = "SELECT * FROM categories";
        List<Category> allCategories = new ArrayList<>();
        try (Connection connection = DBConnection.getDbConnection().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rst = pstm.executeQuery()) {

            while (rst.next()) {
                Category category = new Category(
                        rst.getInt("cat_id"),
                        rst.getString("name"),
                        rst.getString("description")
                );
                allCategories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error fetching categories", e);
        }
        return allCategories;
    }

    @Override
    public boolean add(Category entity) throws Exception {
        return SQLUtil.execute("INSERT INTO categories (cat_id, name, description) VALUES (?,?,?)", entity.getCatId(), entity.getName(), entity.getDescription());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return SQLUtil.execute("DELETE FROM categories WHERE cat_id=?", id);
    }

    @Override
    public boolean update(Category entity) throws Exception {
        return SQLUtil.execute("UPDATE categories SET name=?, description=? WHERE cat_id=?", entity.getName(), entity.getDescription(), entity.getCatId());
    }

    @Override
    public Category searchById(Object id) throws Exception {
        ResultSet rst = SQLUtil.execute("SELECT * FROM categories WHERE cat_id=?", id);
        rst.next();
        return new Category((Integer) id, rst.getString("name"), rst.getString("description"));
    }
}
