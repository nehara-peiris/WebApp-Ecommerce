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

@WebServlet(name = "CategorySaveServlet", value = "/category-save")
public class CategorySaveServlet extends HttpServlet {

    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("cat_name");
        String description = req.getParameter("cat_desc");

        // Input validation (optional but recommended)
        if (name == null || name.isEmpty() || description == null || description.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Category name and description are required.");
            return;
        }

        try {
            CategoryDTO categoryDTO = new CategoryDTO(0, name, description);
            boolean isAdded = categoryBO.addCategory(categoryDTO);

            if (isAdded) {
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Category added successfully.");
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("Failed to add the category.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("An error occurred while saving the category.");
        }
    }
}
