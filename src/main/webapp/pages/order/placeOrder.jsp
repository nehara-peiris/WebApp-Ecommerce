<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="lk.ijse.myclosetecom_web.dto.ProductDTO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Wall</title>
    <style>
        .product-wall {
            display: flex;
            flex-wrap: wrap;
        }
        .product {
            border: 1px solid #ccc;
            margin: 10px;
            padding: 10px;
            width: 200px;
            text-align: center;
        }
        .add-cart-icon {
            font-size: 20px;
            cursor: pointer;
        }
    </style>
    <script>
        function addToCart(productId) {
            fetch('CartServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ productId: productId })
            })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        alert('Product added to cart!');
                    } else {
                        alert('Failed to add product to cart. Please try again.');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Failed to add product to cart. Please try again.');
                });
        }
    </script>
</head>
<body>
<h1>Product Wall</h1>
<div id="productWall" class="product-wall">
    <%
        // Retrieve the list of products from the request attribute
        List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
        if (products != null) {
            for (ProductDTO product : products) {
    %>
    <div class="product">
        <h3><%= product.getName() %></h3>
        <p>Price: $<%= product.getPrice() %></p>
        <p><%= product.getImgUrl() %></p>
        <div class="add-cart-icon" onclick="addToCart(<%= product.getPId() %>)">🛒 Add to Cart</div>
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>