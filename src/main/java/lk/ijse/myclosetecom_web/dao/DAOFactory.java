package lk.ijse.myclosetecom_web.dao;

import lk.ijse.myclosetecom_web.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDAOFactory(){
        return(daoFactory==null)? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CART, CATEGORY, ORDERS, ORDERDETAIL, PRODUCT, REFUND, USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CART:
                return new CartDAOImpl();
            case CATEGORY:
                return new CategoryDAOImpl();
            case ORDERS:
                return new OrderDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();
            case PRODUCT:
                return new ProductDAOImpl();
            case REFUND:
                return new RefundDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}
