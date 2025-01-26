package lk.ijse.myclosetecom_web.controller.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lk.ijse.myclosetecom_web.bo.BOFactory;
import lk.ijse.myclosetecom_web.bo.custom.ProductBO;
import lk.ijse.myclosetecom_web.dto.ProductDTO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "ProductSaveServlet", value = "/product-save")
@MultipartConfig
public class ProductSaveServlet extends HttpServlet {

    private ProductBO productBO = (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Get form data
            int catId = Integer.parseInt(req.getParameter("cat_id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            int qty = Integer.parseInt(req.getParameter("qtyOnHand"));

            // Handle image upload
            Part imagePart = req.getPart("image");
            String uploadPath = getServletContext().getRealPath("") + File.separator + "product-images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir(); // Create directory if it doesn't exist
            }

            // Get the file name of the uploaded image
            String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
            String filePath = uploadPath + File.separator + fileName;

            // Save the uploaded file to the server
            imagePart.write(filePath);

            // Prepare the image URL for the database (relative path)
            String imageUrl = "product-images/" + fileName;

            // Create ProductDTO object with the form data and image URL
            ProductDTO productDTO = new ProductDTO(0, catId, name, price, qty, imageUrl);

            // Save the product
            boolean isAdded = productBO.addProduct(productDTO);

            if (isAdded) {
                resp.sendRedirect("product-save.jsp");
            } else {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add the Product.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error occurred while saving the product.");
        }
    }
}