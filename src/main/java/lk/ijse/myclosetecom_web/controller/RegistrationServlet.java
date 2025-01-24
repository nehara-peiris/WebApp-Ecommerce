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

@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Retrieve parameters
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String role = req.getParameter("role");

        if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(username) || isEmpty(email) || isEmpty(password) || isEmpty(role)) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\": \"All fields are required.\"}");
            return;
        }

        if (!password.equals(confirmPassword)) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\": \"Passwords do not match.\"}");
            return;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        String fullName = firstName + " " + lastName;

        try {
            // Create UserDTO and save user
            UserDTO userDTO = new UserDTO(0, fullName, username, email, hashedPassword, role);
            boolean isAdded = userBO.addUser(userDTO);

            if (isAdded) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("\"message\": \"User registered successfully.\"");
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("\"error\": \"Failed to register user.\"");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("\"error\": \"An error occurred while processing the request.\"");
        }
    }
    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
