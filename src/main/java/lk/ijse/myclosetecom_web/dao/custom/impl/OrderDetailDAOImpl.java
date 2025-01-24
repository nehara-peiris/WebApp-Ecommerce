package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.custom.OrderDetailDAO;
import lk.ijse.myclosetecom_web.entity.OrderDetail;


import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public List<OrderDetail> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean add(OrderDetail entity) throws Exception {
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public boolean update(OrderDetail entity) throws Exception {
        return true;
    }

    @Override
    public OrderDetail searchById(Object id) throws Exception {
        return null;
    }
}
