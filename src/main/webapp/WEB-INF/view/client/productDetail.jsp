<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Mô tả chi tiết sản phẩm</title>

<jsp:include page="_link.jsp" />
</head>

<body>
	<!-- header,navbar start -->
	<jsp:include page="_header.jsp" />
	<jsp:include page="_navbar.jsp" />

	<!-- header,navbar start -->


	<section class="section-pagetop-2 bg-light">
		<div class="container">
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item" aria-current="page"><a href="#">Trang
							chủ</a></li>
					<li class="breadcrumb-item" aria-current="page"><a href="#">Sản phẩm
							</a></li>
					<li class="breadcrumb-item active" aria-current="page">${product.product_name }
						</li>
				</ol>
			</nav>
		</div>
		<!-- container.// -->
	</section>
	<!-- section-pagetop-2.// -->

	<section class="section-content padding-y">
		<div class="container">
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
						
						<dt class="col-xl-4 col-sm-5 col-6">Thời gian giao hàng</dt>
						<dd class="col-xl-8 col-sm-7 col-6">2-5 ngày</dd>

						<dt class="col-xl-4 col-sm-5 col-6">Tình trạng</dt>
						<dd class="col-xl-8 col-sm-7 col-6">còn hàng</dd>

						<dt class="col-xl-4 col-sm-5 col-6">Số lượng</dt>
						<dd class="col-xl-8 col-sm-7 col-6">
							<input type="number" class="form-control w-50" value="1" min="1"
								max="1000" step="1" />
						</dd>
					</dl>

					<div>
						<a href="#" class="btn btn-primary">Mua ngay</a> <a href="#"
							class="btn btn-light ms-2">Thêm vào giỏ hàng</a>
					</div>

				</main>

			</div>
		</div>
		<!-- container.// -->
	</section>
	<!-- section-content.// -->

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
	<!-- section-content.// -->

	<section class="section-content mb-5">
		<div class="container">
			<div class="row">
				<div class="col">
					<h3 class="pb-2">Đánh giá sản phẩm</h3>
					<div class="rattings-wrapper mb-5">
						<div class="sin-rattings mb-4">
							<div class="star-author-all mb-2 clearfix">
								<div class="ratting-author float-start">
									<h5 class="float-start me-3">Lê Thị B</h5>
									<span>20/08/2020</span>
								</div>
								<div class="ratting-star float-end">
									<span class="rating-stars me-2"> <i
										class="bi bi-star-fill active"></i> <i
										class="bi bi-star-fill active"></i> <i
										class="bi bi-star-fill active"></i> <i
										class="bi bi-star-fill active"></i> <i class="bi bi-star-fill"></i>
									</span> <span>(4)</span>
								</div>
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Utenim ad minim veniam, quis nost rud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem
								ipsum dolor sit amet, consectetur adipisicing elit, sed do
								eiusmod tempor incididunt ut labore et dolore magna aliqua.
								Utenim ad minim veniam, quis nost.</p>
						</div>
						<div class="sin-rattings mb-4">
							<div class="star-author-all mb-2 clearfix">
								<div class="ratting-author float-start">
									<h5 class="float-start me-3">Nguyễn Văn C</h5>
									<span>19/08/2020</span>
								</div>
								<div class="ratting-star float-end">
									<span class="rating-stars me-2"> <i
										class="bi bi-star-fill active"></i> <i
										class="bi bi-star-fill active"></i> <i
										class="bi bi-star-fill active"></i> <i
										class="bi bi-star-fill active"></i> <i
										class="bi bi-star-fill active"></i>
									</span> <span>(5)</span>
								</div>
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Utenim ad minim veniam, quis nost rud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
						</div>
					</div>
					<h3 class="pb-2">Thêm đánh giá</h3>
					<div class="ratting-form-wrapper">
						<div class="ratting-form">
							<form action="">
								<div class="row">
									<div class="col-md-3 mb-3">
										<select class="form-select">
											<option disabled selected>Cho sao</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col">
										<textarea class="form-control" placeholder="Nội dung đánh giá"
											rows="3"></textarea>
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Gửi đánh
									giá</button>
							</form>
						</div>
					</div>
				</div>
				<!-- col.// -->
			</div>
			<!-- row.// -->
		</div>
		<!-- container.//  -->
	</section>
	<!-- section-content.// -->


	<jsp:include page="_footer.jsp"></jsp:include>

</body>

</html>