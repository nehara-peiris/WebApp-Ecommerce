package lk.ijse.myclosetecom_web.bo.custom;

import lk.ijse.myclosetecom_web.bo.SuperBO;
import lk.ijse.myclosetecom_web.dto.OrderDTO;

import java.util.List;

public interface OrderBO extends SuperBO {
    List<OrderDTO> getAllOrders() throws Exception;

    boolean addOrder(OrderDTO dto) throws Exception;

    boolean deleteOrder(String id) throws Exception;

    boolean updateOrder(OrderDTO dto) throws Exception;

    OrderDTO searchOrderById(Object id) throws Exception;
}
