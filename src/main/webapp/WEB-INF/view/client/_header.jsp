<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="vi_VN" />
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
				
				<c:if test="${not empty user }">
				<div class="col-lg-5 col-xl-4">
				
					<ul
						class="nav col-12 col-lg-auto my-2 my-lg-0 justify-content-center justify-content-lg-end text-small">
						<li class=><a href="#" class="nav-link text-body"> <i
								class="bi bi-person d-block text-center fs-3"></i>						
						</a> <div class="dropdown-center">
  							<span class="dropdown-toggle"  data-bs-toggle="dropdown" aria-expanded="false">
   											 Tài khoản </span>
  
  								<ul class="dropdown-menu">
  									<li class="text-center"><a
				class="nav-link nav-profile " href="#"
				data-bs-toggle="dropdown"> <img src="img/iphone.jpg" style="max-height: 50px"
					alt="Profile" class="rounded-circle" /> 	
									</a> </li>
									<li class="text-center "><a class="dropdown-item text-primary" href="#">${sessionScope.fullname}</a></li>
    								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/infor">Thông tin tài khoản</a></li>
    								<li><a class="dropdown-item" href="#">Sản phẩm yêu thích</a></li>
    								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
  								</ul>
								</div>
								</li>
						<li><a href="${pageContext.request.contextPath}/order/list" class="nav-link text-body"> <i
								class="bi bi-list-check d-block text-center fs-3"></i> <p class="mt-2">Đơn hàng</p>
						</a></li>
						<li style="position: relative;"><a href="${pageContext.request.contextPath}/cart"
							class="nav-link text-body"> <i
								class="bi bi-cart d-block text-center fs-3"></i> <p class="mt-2"> Giỏ hàng</p> <span
								class="cart-count" id="cartCount">${sessionScope.cart_sum}</span>
						</a></li>
					</ul>
				</div>
				</c:if>
				
			</div>
		</div>
	</section>
</header>