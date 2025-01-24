package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.custom.RefundDAO;
import lk.ijse.myclosetecom_web.entity.Refund;


import java.util.List;

public class RefundDAOImpl implements RefundDAO {
    @Override
    public List<Refund> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean add(Refund entity) throws Exception {
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public boolean update(Refund entity) throws Exception {
        return true;
    }

    @Override
    public Refund searchById(Object id) throws Exception {
        return null;
    }
}
