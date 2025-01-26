package lk.ijse.myclosetecom_web.controller.order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.CartItemBO;
import lk.ijse.myclosetecom_web.bo.custom.OrderBO;
import lk.ijse.myclosetecom_web.bo.custom.OrderDetailBO;
import lk.ijse.myclosetecom_web.bo.custom.ProductBO;
import lk.ijse.myclosetecom_web.dto.OrderDTO;
import lk.ijse.myclosetecom_web.dto.OrderDetailDTO;
import lk.ijse.myclosetecom_web.dto.ProductDTO;
import lk.ijse.myclosetecom_web.dto.UserDTO;
import lk.ijse.myclosetecom_web.entity.Order;
import lk.ijse.myclosetecom_web.entity.Product;
import lk.ijse.myclosetecom_web.entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/placeorder")
public class PlaceOrderServlet extends HttpServlet {

    private final ProductBO productBO = (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);
    private final OrderBO orderBO = (OrderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ORDERS);
    private final CartItemBO cartItemBO = (CartItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CART);
    private final OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ORDERDETAIL);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedItemIds = req.getParameterValues("selectedItems");
        String[] itemQuantities = req.getParameterValues("quantities");
        String[] productIds = req.getParameterValues("productIds");
        Double total = Double.valueOf(req.getParameter("total"));

        if (selectedItemIds != null && itemQuantities != null && productIds != null) {
            List<OrderDetailDTO> orderDetails = new ArrayList<>();
            OrderDTO orderDTO = new OrderDTO();

            for (int i = 0; i < selectedItemIds.length; i++) {
                try {
                    String productId = productIds[i];
                    int quantity = Integer.parseInt(itemQuantities[i]);
                    ProductDTO productDTO = productBO.searchProductById(productId);
                    Product product = new Product();
                    product.setPId(productDTO.getPId());
                    product.setName(productDTO.getName());
                    product.setPrice(productDTO.getPrice());
                    product.setQtyOnHand(productDTO.getQtyOnHand());
                    product.setCatId(productDTO.getCategory());

                    OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
                    orderDetailDTO.setProduct(productDTO);
                    orderDetailDTO.setQty(quantity);
                    orderDetailDTO.setTotPrice(product.getPrice() * quantity);
                    orderDetails.add(orderDetailDTO);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            HttpSession session = req.getSession();
            UserDTO userDTO = (UserDTO) session.getAttribute("user");
            if (userDTO == null) {
                resp.sendRedirect("login.jsp?error=Please login first.");
                return;
            }
            User user = new User();
            user.setUId(userDTO.getUId());
            user.setUName(userDTO.getUName());
            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());

            orderDTO.setTotal(total);
            orderDTO.setUser(user.getUId());
            orderDTO.setStatus("Completed");

            // Save the Order first
            Order order = new Order();
            order.setTotal(orderDTO.getTotal());
            order.setUser(orderDTO.getUser());
            order.setStatus(orderDTO.getStatus());


        } else {
            resp.sendRedirect("cart.jsp?error=No items selected for order.");
        }
        }
}
