<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav
	class="navbar navbar-main navbar-expand-lg navbar-light border-bottom">
	<div class="container">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<strong><i class="bi bi-list"></i> Danh mục sản phẩm</strong>
				</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<c:forEach var="category" items="${categorys}">
						<li><a class="dropdown-item" href="#">${category.category_name }</a></li>
					</c:forEach>	
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">Tất cả danh mục</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link" href="#">Sản phẩm
						mới</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Sản phẩm
						bán chạy</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Khuyến
						mãi</a></li>
			</ul>
			<c:if test="${ empty sessionScope.user}">
				<a class="btn btn-light me-2"
				href="${pageContext.request.contextPath}/register" role="button">Đăng
				ký</a> 
				<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/login" role="button">Đăng
				nhập</a>
			</c:if>
		</div>
	</div>
	<!-- container.// -->
</nav>
<!-- navbar-main.// -->
