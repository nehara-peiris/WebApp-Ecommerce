package lk.ijse.myclosetecom_web.controller.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.ProductBO;
import lk.ijse.myclosetecom_web.dto.ProductDTO;

import java.io.IOException;


@WebServlet(name = "ProductSaveServlet", value = "/product-save")
public class ProductSaveServlet extends HttpServlet {

    ProductBO productBO = (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int catId = Integer.parseInt(req.getParameter("cat_id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("qtyOnHand"));


        try {
            ProductDTO productDTO = new ProductDTO(0, catId, name, price, qty);
            boolean isAdded = productBO.addProduct(productDTO);

            if (isAdded) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Product added successfully.");
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("Failed to add the Product.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            //resp.getWriter().write("An error occurred while saving the Product.");
            resp.getWriter().write(e.toString());
        }
    }


}
