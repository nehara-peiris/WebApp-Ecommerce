<%--
  Created by IntelliJ IDEA.
  User: neha
  Date: 1/24/25
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>E Shop - Bootstrap Ecommerce Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Bootstrap Ecommerce Template" name="keywords">
    <meta content="Bootstrap Ecommerce Template Free Download" name="description">

    <!-- Favicon -->
    <link href="../../assets/img/favicon.ico" rel="icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700&display=swap" rel="stylesheet">

    <!-- CSS Libraries -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../assets/slick/slick.css" rel="stylesheet">
    <link href="../../assets/slick/slick-theme.css" rel="stylesheet">

    <!-- Template Stylesheet -->
<%--
    <link href="css/style.css" rel="stylesheet">
--%>
</head>

<body>
<!-- Top Header Start -->
<div class="top-header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-3">
                <div class="logo">
                    <a href="">
                        <img src="../../assets/img/logo.png" alt="Logo">
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="search">
                    <input type="text" placeholder="Search">
                    <button><i class="fa fa-search"></i></button>
                </div>
            </div>
            <div class="col-md-3">
                <div class="user">
                    <div class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account</a>
                        <div class="dropdown-menu">
                            <a href="#" class="dropdown-item">Login</a>
                            <a href="#" class="dropdown-item">Register</a>
                        </div>
                    </div>
                    <div class="cart">
                        <i class="fa fa-cart-plus"></i>
                        <span>(0)</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Top Header End -->


<!-- Header Start -->
<div class="header">
    <div class="container">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <a href="#" class="navbar-brand">MENU</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                <div class="navbar-nav m-auto">
                    <a href="../../index.jsp" class="nav-item nav-link active">Home</a>
                    <a href="../product/product-list.jsp" class="nav-item nav-link">Products</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                        <div class="dropdown-menu">
                            <a href="../product/product-list.jsp" class="dropdown-item">Product</a>
                            <a href="cart.jsp" class="dropdown-item">Cart</a>
                            <a href="wishlist.html" class="dropdown-item">Wishlist</a>
                            <a href="checkout.html" class="dropdown-item">Checkout</a>
                            <a href="../myAccount.jsp" class="dropdown-item">My Account</a>
                        </div>
                    </div>
                    <a href="../contact.jsp" class="nav-item nav-link">Contact Us</a>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Header End -->


<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">product list</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->


<!-- Product List Start -->
<div class="product-view">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="product-search">
                                    <input type="email" value="Search">
                                    <button><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="product-short">
                                    <div class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Product short by</a>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item">Newest</a>
                                            <a href="#" class="dropdown-item">Popular</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-1.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-2.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-3.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-4.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-5.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-6.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-7.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-8.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="product-item">
                            <div class="product-image">
                                <a href="product-detail.html">
                                    <img src="../../assets/img/product-9.png" alt="Product Image">
                                </a>
                                <div class="product-action">
                                    <a href="#"><i class="fa fa-cart-plus"></i></a>
                                    <a href="#"><i class="fa fa-heart"></i></a>
                                    <a href="#"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="product-content">
                                <div class="title"><a href="#">Phasellus Gravida</a></div>
                                <div class="ratting">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="price">$22 <span>$25</span></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Back to Top -->
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="slick/slick.min.js"></script>


<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>
</html>
