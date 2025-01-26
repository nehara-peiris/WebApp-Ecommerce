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

@WebServlet(name = "ProductUpdateServlet", value = "/product-update")
@MultipartConfig
public class ProductUpdateServlet extends HttpServlet {
    private ProductBO productBO = (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Retrieve form data
            int pId = Integer.parseInt(req.getParameter("p_id"));
            int catId = Integer.parseInt(req.getParameter("cat_id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            int qtyOnHand = Integer.parseInt(req.getParameter("qtyOnHand"));
            String imageUrl = null;

            // Handle image upload
            Part imagePart = req.getPart("image");
            if (imagePart.getSize() > 0) { // Check if a new image is uploaded
                String uploadPath = getServletContext().getRealPath("") + File.separator + "product-images";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir(); // Create directory if it doesn't exist
                }
                String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
                String filePath = uploadPath + File.separator + fileName;

                // Save the uploaded file to the server
                imagePart.write(filePath);
                imageUrl = "product-images/" + fileName; // Prepare the image URL
            }

            // Create ProductDTO object with the form data
            ProductDTO productDTO = new ProductDTO(pId, catId, name, price, qtyOnHand, imageUrl);

            // Update the product
            boolean isUpdated = productBO.updateProduct(productDTO);

            if (isUpdated) {
                req.setAttribute("message", "Product updated successfully.");
            } else {
                req.setAttribute("error", "Failed to update the product.");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid product ID or quantity.");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred while updating the product.");
        }
    }
}