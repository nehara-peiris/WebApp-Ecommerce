package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.SQLUtil;
import lk.ijse.myclosetecom_web.dao.custom.OrderDAO;
import lk.ijse.myclosetecom_web.entity.Order;
import lk.ijse.myclosetecom_web.entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public List<Order> getAll() throws Exception {
        ArrayList<Order> allProducts = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM orders");

        while (rst.next()) {
            Order product = new Order(rst.getInt("o_id"), rst.getInt("user_id"), rst.getDate("date"), rst.getDouble("total"), rst.getString("status"));
            allProducts.add(product);
        }
        return allProducts;
    }

    @Override
    public boolean add(Order entity) throws Exception {
        return SQLUtil.execute("INSERT INTO orders (o_id, user_id, date, total, status) VALUES (?,?,?,?,?)", entity.getOId(), entity.getUser(), entity.getDate(), entity.getTotal(), entity.getStatus());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return SQLUtil.execute("DELETE FROM orders WHERE o_id=?", id);

    }

    @Override
    public boolean update(Order entity) throws Exception {
        return SQLUtil.execute("UPDATE products SET user_id=?, date=?, total=?, status=? WHERE o_id=?,", entity.getUser(), entity.getDate(), entity.getTotal(), entity.getStatus(), entity.getOId());

    }

    @Override
    public Order searchById(Object id) throws Exception {
        return null;
    }
}
