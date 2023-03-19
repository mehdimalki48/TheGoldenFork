<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Home Client Page</title>
	
	

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css" >

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" >

  <link rel="stylesheet" type="text/css" href="css/homepage.css" >
  
</head>

<body>

<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">The Golden Fork v 1.0</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Restaurants</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">All Menus</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Popular</a></li>
                        <li class="nav-item"><a class="nav-link" href="account">My Account</a></li>

                        </li>
                    </ul>
                    <form class="d-flex">
                    <a href="checkout" target="self">
                        <button class="btn btn-outline-dark"  style="margin-right: 15px;" type="button">
<!--                             <i class="bi-cart-fill me-1"></i> -->
							<i class="fa-solid fa-cart-shopping"></i>
                            Panier
                            <span class="badge bg-dark text-white ms-1 rounded-pill ">0</span>
                        </button>
                    </a>
                        <button class="btn btn-dark " type="button">
<!--                             <i class="bi-cart-fill me-1"></i> -->
							<i class="fa-solid fa-user"></i>
                            Account
<!--                             <span class="badge bg-dark text-white ms-1 rounded-pill">0</span> -->
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">The Golden Fork Home Page</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Choose what you want and add to your cart then confirm... cash on delivery service !</p>
<!--                 	<img alt="Logo" src="./assets/images/Logo dark with Headline.png"> -->
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					
					<c:forEach items="${model.list_menus}" var="item">
						<div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">-20%</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="${item.menu_image}" alt="${item.menu_id}" />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${item.menu_name}</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
<!--                                     <span class="text-muted text-decoration-line-through">$20.00</span> -->
                                    ${item.price}Dhs
                                </div>
                            </div>
                            <!-- Product actions-->
                            
                            <form method="post" enctype="multipart/form-data">
	                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                                <div class="text-center">
	                                <button type="submit" name="action" value="addOrderdetail" style="border: none; background-color: transparent;"> 
	                                	<a class="btn btn-outline-dark mt-auto">Add to cart</a>
	                               	</button>
	                                </div>
	                            </div>
	                            <input type="text" hidden='true' name="menuid" value="${item.menu_id}"> 
	                            <input type="text" hidden='true' name="menuprice" value="${item.price}"> 
                            </form>
                        </div>
                	</div>
				</c:forEach>

            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; ltd MM.TECHS 2023 crafted with <i class="fa-solid fa-heart"></i> By mahdi.dev </p></div>
        </footer>



</body>

</html>
    