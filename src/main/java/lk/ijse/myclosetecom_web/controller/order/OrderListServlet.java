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
        List<OrderDTO> orderDTOList = new ArrayList<>();

        try {
            ResultSet rst = (ResultSet) orderBO.getAllOrders();
            while (rst.next()) {
                OrderDTO orderDTO = new OrderDTO(
                        rst.getInt("o_id"),
                        rst.getInt("user_id"),
                        rst.getDate("date"),
                        rst.getDouble("total"),
                        rst.getString("status")
                );
                orderDTOList.add(orderDTO);
            }

            req.setAttribute("orders", orderDTOList);
            req.getRequestDispatcher("order-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
