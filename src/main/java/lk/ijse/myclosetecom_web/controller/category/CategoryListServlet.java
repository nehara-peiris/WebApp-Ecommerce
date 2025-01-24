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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryListServlet", value = "/category-list")
public class CategoryListServlet extends HttpServlet{

    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        try {
            ResultSet rst = (ResultSet) categoryBO.getAllCategories();
            while (rst.next()) {
                CategoryDTO customerDTO = new CategoryDTO(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3)
                );
                categoryDTOList.add(customerDTO);
            }

            req.setAttribute("categories", categoryDTOList);
            req.getRequestDispatcher("category-list.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*
resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            List<CategoryDTO> categoryDTOList = categoryBO.getAllCategories();

            StringBuilder jsonBuilder = new StringBuilder("[");
            for (int i = 0; i < categoryDTOList.size(); i++) {
                CategoryDTO category = categoryDTOList.get(i);
                jsonBuilder.append("{")
                        .append("\"id\":").append(category.getCatId()).append(",")
                        .append("\"name\":\"").append(category.getName()).append("\",")
                        .append("\"description\":\"").append(category.getDescription()).append("\"")
                        .append("}");
                if (i < categoryDTOList.size() - 1) {
                    jsonBuilder.append(",");
                }
            }
            jsonBuilder.append("]");

            // Send JSON response
            resp.getWriter().write(jsonBuilder.toString());
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("An error occurred while retrieving the category list.");
        }
*/