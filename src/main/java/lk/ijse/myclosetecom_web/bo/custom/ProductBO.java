package lk.ijse.myclosetecom_web.bo.custom;

import lk.ijse.myclosetecom_web.bo.SuperBO;
import lk.ijse.myclosetecom_web.dto.ProductDTO;

import java.util.List;

public interface ProductBO extends SuperBO {
    List<ProductDTO> getAllProducts() throws Exception;

    boolean addProduct(ProductDTO dto) throws Exception;

    boolean deleteProduct(String id) throws Exception;

    boolean updateProduct(ProductDTO dto) throws Exception;

    ProductDTO searchProductById(Object id) throws Exception;
}
