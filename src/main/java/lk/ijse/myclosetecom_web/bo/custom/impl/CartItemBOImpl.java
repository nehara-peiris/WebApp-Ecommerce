package lk.ijse.myclosetecom_web.bo.custom.impl;

import lk.ijse.myclosetecom_web.bo.custom.CartItemBO;
import lk.ijse.myclosetecom_web.dao.DAOFactory;
import lk.ijse.myclosetecom_web.dao.custom.CartItemDAO;
import lk.ijse.myclosetecom_web.dto.CartItemDTO;
import lk.ijse.myclosetecom_web.entity.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartItemBOImpl implements CartItemBO {
    CartItemDAO cartItemDAO = (CartItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CART);

    @Override
    public boolean createCartItem(CartItemDTO cartItemDTO) throws Exception {
        CartItem cartItem = new CartItem(
                cartItemDTO.getId(),
                cartItemDTO.getUser(),
                cartItemDTO.getProduct(),
                cartItemDTO.getQuantity()
        );
        return cartItemDAO.add(cartItem);
    }

    @Override
    public CartItemDTO getCartItemById(String cartItemId) throws Exception {
        CartItem cartItem = (CartItem) cartItemDAO.getCartItemsByUserId(cartItemId);
        return new CartItemDTO(
                cartItem.getId(),
                cartItem.getUser(),
                cartItem.getProduct(),
                cartItem.getQuantity()
        );
    }

    @Override
    public boolean updateCartItem(CartItemDTO cartItemDTO) throws Exception {
        CartItem cartItem = new CartItem(
                cartItemDTO.getId(),
                cartItemDTO.getUser(),
                cartItemDTO.getProduct(),
                cartItemDTO.getQuantity()
        );
        return cartItemDAO.update(cartItem);
    }

    @Override
    public boolean deleteCartItem(String cartItemId) throws Exception {
        return cartItemDAO.delete(cartItemId);
    }

    @Override
    public List<CartItemDTO> getCartItemsByUserId(String userId) throws Exception {
        List<CartItem> cartItems = cartItemDAO.getCartItemsByUserId(userId);
        List<CartItemDTO> cartItemDTOList = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            CartItemDTO dto = new CartItemDTO(
                    cartItem.getId(),
                    cartItem.getUser(),
                    cartItem.getProduct(),
                    cartItem.getQuantity()
            );
            cartItemDTOList.add(dto);
        }
        return cartItemDTOList;
    }
}
