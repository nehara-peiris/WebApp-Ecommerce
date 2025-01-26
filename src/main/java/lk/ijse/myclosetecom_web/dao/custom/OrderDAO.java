package lk.ijse.myclosetecom_web.dao.custom;

import lk.ijse.myclosetecom_web.dao.CrudDAO;
import lk.ijse.myclosetecom_web.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO extends CrudDAO<Order> {
    List<Order> getOrdersByCustomerId(String customerId) throws SQLException, ClassNotFoundException;
}
