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

@WebServlet(name = "MyAccountServlet", value = "/myAccount")
public class MyAccountServlet extends HttpServlet {

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    private boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    private String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("updateAccount".equals(action)) {
            handleUpdateAccount(req, resp);
        } else if ("changePassword".equals(action)) {
            handleChangePassword(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action.");
        }
    }

    private void handleUpdateAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        // Assuming the user is already logged in and stored in the session
        UserDTO loggedInUser = (UserDTO) req.getSession().getAttribute("loggedInUser");

        if (loggedInUser == null) {
            resp.sendRedirect("pages/login.jsp");
            return;
        }

        try {
            loggedInUser.setUName(username);
            loggedInUser.setEmail(email);
            userBO.updateUser(loggedInUser);

            req.getSession().setAttribute("loggedInUser", loggedInUser);
            req.setAttribute("success", "Account details updated successfully.");
            req.getRequestDispatcher("pages/myAccount.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Failed to update account details.");
            req.getRequestDispatcher("pages/myAccount.jsp").forward(req, resp);
        }
    }

    private void handleChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPassword = req.getParameter("currentPassword");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");

        UserDTO loggedInUser = (UserDTO) req.getSession().getAttribute("loggedInUser");

        if (loggedInUser == null) {
            resp.sendRedirect("pages/login.jsp");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            req.setAttribute("error", "New password and confirm password do not match.");
            req.getRequestDispatcher("pages/myAccount.jsp").forward(req, resp);
            return;
        }

        try {
            if (verifyPassword(currentPassword, loggedInUser.getPassword())) {
                String hashedNewPassword = hashPassword(newPassword);
                loggedInUser.setPassword(hashedNewPassword);
                userBO.getUsernameAndPassword(loggedInUser.getUName());

                req.getSession().setAttribute("loggedInUser", loggedInUser);
                req.setAttribute("success", "Password changed successfully.");
                req.getRequestDispatcher("pages/myAccount.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Current password is incorrect.");
                req.getRequestDispatcher("pages/myAccount.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Failed to change password.");
            req.getRequestDispatcher("pages/myAccount.jsp").forward(req, resp);
        }
    }
}
