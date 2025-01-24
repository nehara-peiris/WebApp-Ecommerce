package lk.ijse.myclosetecom_web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.UserBO;
import lk.ijse.myclosetecom_web.dto.UserDTO;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            UserDTO userDTO = userBO.getUsernameAndPassword(username);

            if (userDTO != null && verifyPassword(password, userDTO.getPassword())) {
                // Successful login
                req.getSession().setAttribute("loggedInUser", userDTO);

                // Check user role and redirect accordingly
                if ("customer".equalsIgnoreCase(userDTO.getRole())) {
                    resp.sendRedirect("pages/userDashboard.jsp");
                } else if ("admin".equalsIgnoreCase(userDTO.getRole())) {
                    resp.sendRedirect("pages/adminDashboard.jsp");
                } else {
                    req.setAttribute("error", "Invalid user role.");
                    req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
                }
            } else {
                // Login failed
                req.setAttribute("error", "Incorrect username or password.");
                req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred while processing your login request.");
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        }
    }
}
