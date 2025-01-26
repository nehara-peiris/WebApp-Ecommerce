package lk.ijse.myclosetecom_web.dao.custom;

import lk.ijse.myclosetecom_web.dao.CrudDAO;
import lk.ijse.myclosetecom_web.entity.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDAO extends CrudDAO<Cart> {
    List<Cart> getCartByUser(int userId) throws SQLException, ClassNotFoundException;
}
