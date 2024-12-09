<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/client.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<title>Insert title here</title>

</head>
<body>
	<header class="section-header">
	<section class="header-main border-bottom">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-3 py-3">
					<a class="text-body" href="${pageContext.request.contextPath}">
						<h3>Countduck</h3>
					</a>
				</div>
				<div class="col-lg-4 col-xl-5">
					<form action="#" class="search">
						<div class="input-group w-100">
							<input type="text" class="form-control"
								placeholder="Nhập từ khóa cần tìm ...">
							<button class="btn btn-primary" type="button">
								<i class="bi bi-search"></i>
							</button>
						</div>
					</form>
				</div>
				
				
				<div class="col-lg-5 col-xl-4">
				
					<ul
						class="nav col-12 col-lg-auto my-2 my-lg-0 justify-content-center justify-content-lg-end text-small">
						<li class=><a href="#" class="nav-link text-body"> <i
								class="bi bi-person d-block text-center fs-3"></i>						
						</a> <div class="dropdown-center">
  							<span class="dropdown-toggle"  data-bs-toggle="dropdown" aria-expanded="false">
   											 Tài khoản </span>
  
  								<ul class="dropdown-menu">
    								<li><a class="dropdown-item" href="#">Action</a></li>
    								<li><a class="dropdown-item" href="#">Action two</a></li>
    								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
  								</ul>
</div>
								</li>
						<li><a href="#" class="nav-link text-body"> <i
								class="bi bi-list-check d-block text-center fs-3"></i> <p class="mt-2">Đơn hàng</p>
						</a></li>
						<li style="position: relative;"><a href="#"
							class="nav-link text-body"> <i
								class="bi bi-cart d-block text-center fs-3"></i> <p class="mt-2"> Giỏ hàng</p> <span
								class="cart-count" id="cartCount">3</span>
						</a></li>
					</ul>
				</div>
				
			</div>
		</div>
	</section>
</header>

</body>
</html>