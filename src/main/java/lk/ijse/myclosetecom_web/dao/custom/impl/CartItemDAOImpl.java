package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.SQLUtil;
import lk.ijse.myclosetecom_web.dao.custom.CartItemDAO;
import lk.ijse.myclosetecom_web.db.DBConnection;
import lk.ijse.myclosetecom_web.entity.CartItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartItemDAOImpl implements CartItemDAO {

    @Override
    public boolean add(CartItem entity) throws Exception {
        return SQLUtil.execute("INSERT INTO cart_item (id, user_id, product_id, quantity) VALUES (?, ?, ?, ?)", entity.getId(), entity.getUser(), entity.getProduct(), entity.getQuantity());
    }


    @Override
    public CartItem searchById(Object id) throws Exception {
        ResultSet rst = SQLUtil.execute("SELECT * FROM cart_item WHERE id = ?", id);
        rst.next();
        return new CartItem((Long) id, rst.getInt("user_id"), rst.getInt("p_id"), rst.getInt("quantity"));
    }

    @Override
    public boolean update(CartItem entity) throws Exception {
        return SQLUtil.execute("UPDATE cart_item SET user_id = ?, product_id = ?, quantity = ? WHERE id = ?", entity.getUser(), entity.getProduct(), entity.getQuantity(), entity.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return SQLUtil.execute("DELETE FROM cart_item WHERE id = ?", id);
    }

    @Override
    public List<CartItem> getAll() throws Exception {
        String sql = "SELECT * FROM cart_item";
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = DBConnection.getDbConnection().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                cartItems.add(new CartItem(
                        rs.getLong("id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error fetching categories", e);
        }
        return cartItems;
    }

    @Override
    public List<CartItem> getCartItemsByUserId(String userId) throws Exception {
        String sql = "SELECT * FROM cart_item WHERE user_id = ?";
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = DBConnection.getDbConnection().getConnection();
             PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setLong(1, Long.parseLong(userId));
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    cartItems.add(new CartItem(
                            rs.getLong("id"),
                            rs.getInt("user_id"),
                            rs.getInt("product_id"),
                            rs.getInt("quantity")
                    ));
                }
            }
        }
        return cartItems;
    }
}
