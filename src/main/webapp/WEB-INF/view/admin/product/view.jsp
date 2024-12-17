<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>${product.product_name }</title>
<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect" />
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet" />
<!-- Vendor CSS Files -->
<jsp:include page="../layout/_link.jsp"/>
</head>
<body>
<jsp:include page="../layout/_header.jsp" />
<jsp:include page="../layout/_sildebar.jsp" />
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Quản lý sản phẩm</h1>
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a class="text-decoration-none"
						href="${pageContext.request.contextPath}/admin">Trang chủ</a></li>
					<li class="breadcrumb-item ">Sản phẩm</li>
					<li class="breadcrumb-item active">Chi tiết</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<div class="d-flex justify-content-between">
			<span class="fs-3 text-primary">Chi tiết sản phẩm</span> <a
				class="btn btn-primary">Quay lại</a>
		</div>
		
		<hr>
		<div class="row">

				<aside class="col-md-5 col-lg-6 mb-md-0 mb-4">
					<div id="productImageCarousel" class="carousel slide"
						data-bs-ride="carousel">
						<div class="carousel-indicators">
							<button type="button" data-bs-target="#productImageCarousel"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide 1"></button>
							<button type="button" data-bs-target="#productImageCarousel"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#productImageCarousel"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
						</div>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="${pageContext.request.contextPath}/img/product/${product.product_image}" class="d-block w-100" alt="...">
							</div>
							<div class="carousel-item ">
								<img src="${pageContext.request.contextPath}/img/product/${product.product_image}" class="d-block w-100" alt="...">
							</div>
							<div class="carousel-item ">
								<img src="${pageContext.request.contextPath}/img/product/${product.product_image}" class="d-block w-100" alt="...">
							</div>
							
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#productImageCarousel" data-bs-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Trước</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#productImageCarousel" data-bs-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Sau</span>
						</button>
					</div>
				</aside>

				<main class="col-md-7 col-lg-6">

					<h2 class="title">${product.product_name }</h2>

					<div class="rating-wrap my-3">
						<span class="rating-stars me-2"> <i
							class="bi bi-star-fill active"></i> <i
							class="bi bi-star-fill active"></i> <i
							class="bi bi-star-fill active"></i> <i class="bi bi-star-fill "></i>
							<i class="bi bi-star-fill "></i>
						</span> <small class="label-rating text-muted me-2">20 đánh giá</small> <small
							class="label-rating text-success"><i
							class="bi bi-bag-check-fill"></i> 150 đã mua</small>
					</div>

					<div class="mb-4">
						<span class="price h4">
						<fmt:formatNumber type="number" value="${product.product_discount}" />
                                                            VND
						</span> 
						<span class="ms-2 text-muted text-decoration-line-through">
					<fmt:formatNumber type="number" value="${product.product_price}" />
                                                            VND
						</span>
					</div>
					<div>
						<b>Thông số</b>
						<p>${product.product_shortdesc}</p>
					</div>
					<dl class="row mb-4">											
						<dt class="col-xl-4 col-sm-5 col-6">Phù hợp</dt>
						<dd class="col-xl-8 col-sm-7 col-6"><c:out value="${product.product_target}" ></c:out></dd>
					
					</dl>

					

				</main>

			</div>
			
		<br> 
		<section class="section-content mb-4">
		<div class="container">
			<div class="row">
				<div class="col">
					<h3 class="pb-2">Mô tả sản phẩm</h3>
					<p>
						${product.product_description}
					</p>
				</div>
			</div>
		</div>
		<!-- container.// -->
	</section>
		<br>

	</main>




<jsp:include page="../layout/_footer.jsp"></jsp:include>
</body>
</html>