package lk.ijse.myclosetecom_web.bo.custom.impl;

import lk.ijse.myclosetecom_web.bo.custom.OrderDetailBO;
import lk.ijse.myclosetecom_web.dao.DAOFactory;
import lk.ijse.myclosetecom_web.dao.custom.OrderDetailDAO;
import lk.ijse.myclosetecom_web.dto.OrderDetailDTO;
import lk.ijse.myclosetecom_web.entity.OrderDetail;

public class OrderDetailBOImpl implements OrderDetailBO {

    private final OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);

    public boolean addOrderDetail(OrderDetailDTO dto) throws Exception {
        // Create OrderDetail entity from OrderDetailDTO
        OrderDetail orderDetail = new OrderDetail(
                dto.getOrder().getOId(),
                dto.getProduct().getPId(),
                dto.getQty(),
                dto.getUnitPrice(),
                dto.getTotPrice()
        );

        // Call DAO method to save OrderDetail entity
        return orderDetailDAO.add(orderDetail);
    }
}
