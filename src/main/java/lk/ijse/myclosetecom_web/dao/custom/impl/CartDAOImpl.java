package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.custom.CartDAO;
import lk.ijse.myclosetecom_web.entity.Cart;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
    @Override
    public List<Cart> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean add(Cart entity) throws Exception {
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public boolean update(Cart entity) throws Exception {
        return true;
    }

    @Override
    public Cart searchById(Object id) throws Exception {
        return null;
    }
}
