<%@ page import="java.util.List" %>
<%@ page import="lk.ijse.myclosetecom_web.dto.ProductDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Product Management</h2>

    <!-- Product Table -->
    <table class="table table-bordered table-striped  table-responsive">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Image URL</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
            if (products != null && !products.isEmpty()) {
                for (ProductDTO product : products) {
        %>
        <tr>
            <td><%=product.getPId()%></td>
            <td><%=product.getName()%></td>
            <td><%=product.getCategory()%></td>
            <td><%=product.getPrice()%></td>
            <td><%=product.getQtyOnHand()%></td>
            <td><%=product.getImgUrl()%></td>
            <td>
                <button type="button" class="btn btn-warning btn-sm" data-bs-toggle="modal" data-bs-target="#updateModal<%=product.getPId()%>">Update</button>
                <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal<%=product.getPId()%>">Delete</button>
            </td>
        </tr>

        <!-- Update Modal -->
        <div class="modal fade" id="updateModal<%=product.getPId()%>" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateModalLabel">Update Product</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="updateproduct" method="post">
                        <div class="modal-body">
                            <input type="hidden" name="productId" value="<%=product.getPId()%>">
                            <div class="mb-3">
                                <label for="productName<%=product.getPId()%>" class="form-label">Product Name</label>
                                <input type="text" class="form-control" id="productName<%=product.getPId()%>" name="productName" value="<%=product.getName()%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="productCategory<%=product.getPId()%>" class="form-label">Category</label>
                                <input type="text" class="form-control" id="productCategory<%=product.getPId()%>" name="productCategory" value="<%=product.getCategory()%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="productPrice<%=product.getPId()%>" class="form-label">Price</label>
                                <input type="number" class="form-control" id="productPrice<%=product.getPId()%>" name="productPrice" value="<%=product.getPrice()%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="productStock<%=product.getPId()%>" class="form-label">Stock</label>
                                <input type="number" class="form-control" id="productStock<%=product.getPId()%>" name="productStock" value="<%=product.getQtyOnHand()%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="productImageUrl<%=product.getPId()%>" class="form-label">Image URL</label>
                                <input type="url" class="form-control" id="productImageUrl<%=product.getPId()%>" name="productImageUrl" value="<%=product.getImgUrl()%>" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-warning">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Delete Modal -->
        <div class="modal fade" id="deleteModal<%=product.getPId()%>" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deleteModalLabel">Delete Product</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to delete this product?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <form action="deleteproduct" method="post" style="display:inline;">
                            <input type="hidden" name="productId" value="<%=product.getPId()%>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="8" class="text-center">No Products available.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <!-- Add Product Button -->
    <div class="text-end">
        <a href="product-save.jsp" class="btn btn-primary">Add New Product</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>