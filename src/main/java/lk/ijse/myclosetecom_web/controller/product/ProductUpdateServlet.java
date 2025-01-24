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

@WebServlet(name = "ProductUpdateServlet", value = "/product-update")
public class ProductUpdateServlet extends HttpServlet {
    ProductBO productBO = (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int p_id = Integer.parseInt(req.getParameter("p_id"));
            int catId = Integer.parseInt(req.getParameter("cat_id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            int qty = Integer.parseInt(req.getParameter("qtyOnHand"));

            if (!isInputValid(name)) {
                sendErrorResponse(resp, "Category name and description are required.");
                return;
            }

            ProductDTO productDTO = new ProductDTO(p_id, catId, name, price, qty);
            boolean isUpdated = productBO.updateProduct(productDTO);

            if (isUpdated) {
                sendSuccessResponse(resp, "Product updated successfully.");
            } else {
                sendErrorResponse(resp, "Failed to update the Product.");
            }
        } catch (NumberFormatException e) {
            sendErrorResponse(resp, "Invalid Product ID.");
        } catch (Exception e) {
            e.printStackTrace();
            sendErrorResponse(resp, e.toString());
        }
    }

    private boolean isInputValid(String name) {
        return name != null && !name.isEmpty();
    }

    private void sendSuccessResponse(HttpServletResponse resp, String message) throws IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\": \"" + message + "\"}");
    }

    private void sendErrorResponse(HttpServletResponse resp, String message) throws IOException {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"error\": \"" + message + "\"}");
    }
}
