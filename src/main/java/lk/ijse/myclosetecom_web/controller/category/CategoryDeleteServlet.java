package lk.ijse.myclosetecom_web.controller.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.CategoryBO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "CategoryDeleteServlet", value = "/category-delete")
public class CategoryDeleteServlet extends HttpServlet {

    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cat_id = req.getParameter("cat_id");

        try{
            boolean isDeleted = categoryBO.deleteCategory(cat_id);
            if (isDeleted){
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Category deleted successfully.");
            }else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("Failed to delete the category.");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
