package lk.ijse.myclosetecom_web.controller.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.CategoryBO;
import lk.ijse.myclosetecom_web.dto.CategoryDTO;

import java.io.IOException;

@WebServlet(name = "CategoryUpdateServlet", value = "/category-update")
public class CategoryUpdateServlet extends HttpServlet {
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("cat_id"));
            String name = req.getParameter("cat_name");
            String description = req.getParameter("cat_desc");

            if (!isInputValid(name, description)) {
                sendErrorResponse(resp, "Category name and description are required.");
                return;
            }

            CategoryDTO categoryDTO = new CategoryDTO(id, name, description);
            boolean isUpdated = categoryBO.updateCategory(categoryDTO);

            if (isUpdated) {
                sendSuccessResponse(resp, "Category updated successfully.");
            } else {
                sendErrorResponse(resp, "Failed to update the category.");
            }
        } catch (NumberFormatException e) {
            sendErrorResponse(resp, "Invalid category ID.");
        } catch (Exception e) {
            e.printStackTrace();
            sendErrorResponse(resp, "An error occurred while updating the category.");
        }
    }

    private boolean isInputValid(String name, String description) {
        return name != null && !name.isEmpty() && description != null && !description.isEmpty();
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
