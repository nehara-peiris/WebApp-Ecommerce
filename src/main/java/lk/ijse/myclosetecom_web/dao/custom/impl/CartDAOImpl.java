package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.SQLUtil;
import lk.ijse.myclosetecom_web.dao.custom.CartDAO;
import lk.ijse.myclosetecom_web.entity.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
    @Override
    public List<Cart> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean add(Cart entity) throws Exception {
        return SQLUtil.execute("INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)", entity.getUserId(), entity.getProductId(), entity.getQuantity());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return SQLUtil.execute("DELETE FROM cart WHERE cart_id=?", id);
    }

    @Override
    public boolean update(Cart entity) throws Exception {
        return SQLUtil.execute("UPDATE cart SET user_id=?, p_id=? quantity=? WHERE cart_id=?", entity.getUserId(), entity.getProductId(), entity.getQuantity(), entity.getCartId());
    }

    @Override
    public Cart searchById(Object id) throws Exception {
        return null;
    }

    @Override
    public List<Cart> getCartByUser(int userId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM cart WHERE user_id = ?", userId);

    }
}
