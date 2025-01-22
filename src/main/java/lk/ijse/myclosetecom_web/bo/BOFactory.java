package lk.ijse.myclosetecom_web.bo;

import lk.ijse.myclosetecom_web.bo.custom.impl.*;
import lk.ijse.myclosetecom_web.dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CART, CATEGORY, ORDERS, ORDERDETAIL, PRODUCT, REFUND, USER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CART:
                return new CartBOImpl();
            case CATEGORY:
                return new CategoryBOImpl();
            case ORDERS:
                return new OrderBOImpl();
            case ORDERDETAIL:
                return new OrderDetailBOImpl();
            case PRODUCT:
                return new ProductBOImpl();
            case REFUND:
                return new RefundBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
