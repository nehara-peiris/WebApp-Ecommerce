package lk.ijse.myclosetecom_web.bo.custom;

import lk.ijse.myclosetecom_web.bo.SuperBO;
import lk.ijse.myclosetecom_web.dto.CartItemDTO;

import java.util.List;

public interface CartItemBO extends SuperBO {

    boolean createCartItem(CartItemDTO cartItemDTO) throws Exception;

    CartItemDTO getCartItemById(String cartItemId) throws Exception;

    boolean updateCartItem(CartItemDTO cartItemDTO) throws Exception;

    boolean deleteCartItem(String cartItemId) throws Exception;

    List<CartItemDTO> getCartItemsByUserId(String userId) throws Exception;


}