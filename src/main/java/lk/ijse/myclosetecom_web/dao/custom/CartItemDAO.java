package lk.ijse.myclosetecom_web.dao.custom;

import lk.ijse.myclosetecom_web.dao.CrudDAO;
import lk.ijse.myclosetecom_web.entity.CartItem;

import java.util.List;

public interface CartItemDAO extends CrudDAO<CartItem> {
    List<CartItem> getCartItemsByUserId(String userId) throws Exception;
}