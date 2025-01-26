package lk.ijse.myclosetecom_web.dao.custom.impl;

import lk.ijse.myclosetecom_web.dao.SQLUtil;
import lk.ijse.myclosetecom_web.dao.custom.ProductDAO;
import lk.ijse.myclosetecom_web.entity.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> getAll() throws Exception {
        ArrayList<Product> allProducts = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM products");

        while (rst.next()) {
            Product product = new Product(rst.getInt("p_id"), rst.getInt("cat_id"), rst.getString("name"), rst.getDouble("price"), rst.getInt("qtyOnHand"), rst.getString("imgUrl"));
            allProducts.add(product);
        }
        return allProducts;
    }

    @Override
    public boolean add(Product entity) throws Exception {
        return SQLUtil.execute("INSERT INTO products (p_id, cat_id, name, price, qtyOnHand, img_url) VALUES (?,?,?,?,?,?)", entity.getPId(), entity.getCatId(), entity.getName(), entity.getPrice(), entity.getQtyOnHand(), entity.getImgUrl());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return SQLUtil.execute("DELETE FROM products WHERE p_id=?", id);

    }

    @Override
    public boolean update(Product entity) throws Exception {
        return SQLUtil.execute("UPDATE products SET cat_id=?, name=?, price=?, qtyOnHand=?, img_url=? WHERE p_id=?", entity.getCatId(), entity.getName(), entity.getPrice(), entity.getQtyOnHand(), entity.getImgUrl(), entity.getPId());
    }

    @Override
    public Product searchById(Object id) throws Exception {
        return SQLUtil.execute("SELECT * FROM products WHERE p_id=?", id);
    }

    @Override
    public Product searchByName(String name) throws Exception {
        ResultSet rst = SQLUtil.execute("SELECT * FROM products WHERE name LIKE ?", name);
        rst.next();
        return new Product(rst.getInt("p_id"), rst.getInt("cat_id"), rst.getString("name"), rst.getDouble("price"), rst.getInt("qtyOnHand"), rst.getString("imgUrl"));
    }
}
