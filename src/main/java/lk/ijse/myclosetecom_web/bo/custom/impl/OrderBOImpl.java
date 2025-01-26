package lk.ijse.myclosetecom_web.bo.custom.impl;

import lk.ijse.myclosetecom_web.bo.custom.OrderBO;
import lk.ijse.myclosetecom_web.dao.DAOFactory;
import lk.ijse.myclosetecom_web.dao.custom.OrderDAO;
import lk.ijse.myclosetecom_web.dto.OrderDTO;
import lk.ijse.myclosetecom_web.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERS);

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        List<Order> orderList = orderDAO.getAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            orderDTOList.add(new OrderDTO(order.getOId(), order.getUser(), order.getDate(), order.getTotal(), order.getStatus()));
        }
        return orderDTOList;
    }

    @Override
    public boolean addOrder(OrderDTO dto) throws Exception {
        Order order = new Order(dto.getOId(), dto.getUser(), dto.getDate(), dto.getTotal(), dto.getStatus());
        return orderDAO.add(order);
    }

    @Override
    public boolean deleteOrder(String id) throws Exception {
         return orderDAO.delete(id);
    }

    @Override
    public boolean updateOrder(OrderDTO dto) throws Exception {
        Order order = new Order(dto.getOId(), dto.getUser(), dto.getDate(), dto.getTotal(), dto.getStatus());
        return orderDAO.update(order);
    }

    @Override
    public OrderDTO searchOrderById(Object id) throws Exception {
        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(String customerId) throws SQLException, ClassNotFoundException {
        List<Order> orders = orderDAO.getOrdersByCustomerId(customerId);

        // Manually convert List<Order> to List<OrderDTO>
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOId(order.getOId());
            orderDTO.setUser(order.getUser());
            orderDTO.setDate(order.getDate());
            orderDTO.setTotal(order.getTotal());
            orderDTO.setStatus(order.getStatus());
            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
    }
}
