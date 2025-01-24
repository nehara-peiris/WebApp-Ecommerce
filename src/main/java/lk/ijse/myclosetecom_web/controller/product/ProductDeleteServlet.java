package lk.ijse.myclosetecom_web.controller.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.ProductBO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductDeleteServlet", value = "/product-delete")
public class ProductDeleteServlet extends HttpServlet {

    ProductBO productBO = (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p_id = req.getParameter("p_id");

        try{
            boolean isDeleted = productBO.deleteProduct(p_id);
            if (isDeleted){
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Product deleted successfully.");
            }else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("Failed to delete the Product.");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
