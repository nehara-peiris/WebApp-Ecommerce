package lk.ijse.myclosetecom_web.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.CategoryBO;
import lk.ijse.myclosetecom_web.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

    CategoryBO categoryBO = (CategoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if (action == null) {
                action = "list";
            }

            switch (action) {
                case "list":
                    listCategories(req, resp);
                    break;
                case "search":
                    searchCategory(req, resp);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            switch (action) {
                case "add":
                    addCategory(req, resp);
                    break;
                case "update":
                    updateCategory(req, resp);
                    break;
                case "delete":
                    deleteCategory(req, resp);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listCategories(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<CategoryDTO> categoryList = categoryBO.getAllCategories();
        req.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/category-list.jsp");
        dispatcher.forward(req, resp);
    }

    private void searchCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.parseLong(req.getParameter("id"));
        CategoryDTO category = categoryBO.searchCategoryById(id);

        if (category != null) {
            req.setAttribute("category", category);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/category-details.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Category not found");
        }
    }

    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        CategoryDTO category = new CategoryDTO(null, name, description);
        boolean isAdded = categoryBO.addCategory(category);

        if (isAdded) {
            resp.sendRedirect("category?action=list");
        } else {
            req.setAttribute("error", "Failed to add category");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/category-form.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        CategoryDTO category = new CategoryDTO(id, name, description);
        boolean isUpdated = categoryBO.updateCategory(category);

        if (isUpdated) {
            resp.sendRedirect("category?action=list");
        } else {
            req.setAttribute("error", "Failed to update category");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/category-form.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.parseLong(req.getParameter("id"));

        CategoryDTO category = new CategoryDTO(id, null, null);
        boolean isDeleted = categoryBO.deleteCategory(category);

        if (isDeleted) {
            resp.sendRedirect("category?action=list");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Failed to delete category");
        }
    }
}
