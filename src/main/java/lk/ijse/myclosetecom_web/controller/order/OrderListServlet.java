package lk.ijse.myclosetecom_web.controller.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.OrderBO;
import lk.ijse.myclosetecom_web.dto.OrderDTO;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderListServlet", value="/order-list")
public class OrderListServlet extends HttpServlet {

    OrderBO orderBO = (OrderBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ORDERS);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String orderId = req.getParameter("id");
            String customerId = req.getParameter("customerId");

            if (orderId != null) {
                // Fetch a single order by ID
                OrderDTO order = orderBO.searchOrderById(orderId);
                if (order != null) {
                    req.setAttribute("order", order); // Set the single order as an attribute
                    req.getRequestDispatcher("/orderDetails.jsp").forward(req, resp); // Forward to details page
                } else {
                    req.setAttribute("error", "Order not found");
                    req.getRequestDispatcher("/error.jsp").forward(req, resp);
                }
            } else if (customerId != null) {
                // Fetch orders by customer ID
                List<OrderDTO> orders = orderBO.getOrdersByCustomerId(customerId);
                req.setAttribute("orders", orders); // Set the orders list as an attribute
                req.getRequestDispatcher("/customerOrders.jsp").forward(req, resp); // Forward to customer orders page
            } else {
                // Fetch all orders
                List<OrderDTO> orders = orderBO.getAllOrders();
                req.setAttribute("orders", orders); // Set the orders list as an attribute
                req.getRequestDispatcher("/orderView.jsp").forward(req, resp); // Forward to all orders page
            }
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp); // Forward to an error page
        }
    }
}
