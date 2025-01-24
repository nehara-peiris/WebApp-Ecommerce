package lk.ijse.myclosetecom_web.bo.custom.impl;

import lk.ijse.myclosetecom_web.bo.custom.ProductBO;
import lk.ijse.myclosetecom_web.dao.DAOFactory;
import lk.ijse.myclosetecom_web.dao.custom.ProductDAO;
import lk.ijse.myclosetecom_web.dto.ProductDTO;
import lk.ijse.myclosetecom_web.entity.Category;
import lk.ijse.myclosetecom_web.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBOImpl implements ProductBO {

    ProductDAO productDAO = (ProductDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);

    @Override
    public List<ProductDTO> getAllProducts() throws Exception {
        List<Product> productList = productDAO.getAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            productDTOList.add(new ProductDTO(product.getPId(), product.getCatId(), product.getName(), product.getPrice(), product.getQtyOnHand()));
        }
        return productDTOList;
    }

    @Override
    public boolean addProduct(ProductDTO dto) throws Exception {
        Product product = new Product(dto.getPId(), dto.getCategory(), dto.getName(), dto.getPrice(), dto.getQtyOnHand());
        return productDAO.add(product);
    }

    @Override
    public boolean deleteProduct(String id) throws Exception {
         return productDAO.delete(id);
    }

    @Override
    public boolean updateProduct(ProductDTO dto) throws Exception {
        Product product = new Product(dto.getPId(), dto.getCategory(), dto.getName(), dto.getPrice(), dto.getQtyOnHand());
        return productDAO.update(product);
    }

    @Override
    public ProductDTO searchProductById(Object id) throws Exception {
        return null;
    }
}
