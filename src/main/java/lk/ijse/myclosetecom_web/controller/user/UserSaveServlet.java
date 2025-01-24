package lk.ijse.myclosetecom_web.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.UserBO;
import lk.ijse.myclosetecom_web.dto.UserDTO;

import java.io.IOException;

@WebServlet(name = "UserSaveServlet", value = "/user-save")
public class UserSaveServlet extends HttpServlet {

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullname");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String urole = req.getParameter("role");

        if (fullName == null || fullName.isEmpty() || username == null || username.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty() || urole == null || urole.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Category name and description are required.");
            return;
        }

        try {
            UserDTO userDTO = new UserDTO(0, fullName, username, email, password, urole);
            boolean isAdded = userBO.addUser(userDTO);

            if (isAdded) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("User added successfully.");
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("Failed to add the User.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("An error occurred while saving the User.");
        }
    }
}
