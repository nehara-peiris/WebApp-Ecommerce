package lk.ijse.myclosetecom_web.dao.custom;

import lk.ijse.myclosetecom_web.dao.CrudDAO;
import lk.ijse.myclosetecom_web.entity.Product;

public interface ProductDAO extends CrudDAO<Product> {
    Product searchByName(String name) throws Exception;
}
