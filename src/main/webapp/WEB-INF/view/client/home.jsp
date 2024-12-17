<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<jsp:include page="_link.jsp" />
<title>Trang chủ</title>

</head>

<body>
	<!-- link header và navbar - start -->
	<jsp:include page="_header.jsp" />
	<jsp:include page="_navbar.jsp" />
	<!-- link header và navbar -ednd -->
	

	<section class="section-content mb-2">
		<div class="container">
			<header class="section-heading py-4 d-flex justify-content-between">
				<h3 class="section-title">Danh mục sản phẩm</h3>
				<a class="btn btn-secondary" href="#" role="button"
					style="height: fit-content;">Xem tất cả</a>
			</header>
			<!-- section-heading.// -->
			<div class="row item-grid">
			<c:forEach var="category" items="${categorys}">
				<div class="col-lg-3 col-md-6">
					<div class="card mb-4">
						<div class="card-body">
							<a href="#" class="stretched-link">
								<div class="d-flex align-items-center">
									<img src="img/${category.category_image }" class="category-img" >
									 <span class="category-title ms-3  fs-5 text-dark">${category.category_name}
									 </span>					
								</div>
								
							</a>
						</div>
					
					</div>
				</div>
				</c:forEach>
				<!-- col.// -->

			</div>
			<!-- row.// -->
		</div>
	
		<!-- container.// -->
	</section>
	<!-- section-content.// -->

	<section class="section-content mb-5">
		<div class="container">
			<header class="section-heading py-4 d-flex justify-content-between">
				<h3 class="section-title">Danh sách sản phẩm</h3>
				<a class="btn btn-secondary" href="#" role="button"
					style="height: fit-content;">Xem tất cả</a>
			</header>
			<!-- section-heading.// -->
			<div class="row item-grid ">
				<c:forEach var="product" items="${ products}">		
					<div class="col-lg-3 col-md-6">
						<div class="card p-3 mb-4 text-center">
						<a href="${pageContext.request.contextPath }/product?id=${product.product_id}"
							class="img-wrap text-center"> <img
							class="img-fluid product-img" src="${pageContext.request.contextPath}/img/product/${product.product_image}">
						</a>
						<figcaption class="info-wrap mt-2 ">
							<a href="#" class="title fs-4 text-black">${product.product_name}</a>
							<p class="price-old ">
								Giá cũ: <span><fmt:formatNumber type="number" value="${product.product_price}" />
                                                            VND
						</span> 
							</p>
							<div class="price mt-1 fw-bold fs-5">
								<span class="text-danger"><fmt:formatNumber type="number" value="${product.product_discount }"/>
                                                            VND</span>
							</div>
							<a href="${pageContext.request.contextPath}/cart/add?id=${product.product_id}" class="btn btn-primary mt-2 add-to-cart  "><i
								class="bi bi-cart"></i>Thêm vào giỏ hàng</a>

						</figcaption>
					</div>
				</div>
				</c:forEach>
				
				
				

			<div>
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<c:if test="${currentPage > 1}">
					<li class="page-item" id="prevPage"><a class="page-link"
					href="?page=${currentPage - 1}">Trang trước</a></li>
				</c:if>
				 <c:forEach begin="1" end="${totalPages}" var="i">
				 <c:choose>
				 <c:when test="${currentPage eq i}">
				<li class="page-item active" id="page1"><a class="page-link"
					href="#">${i}</a></li>
				</c:when>
				<c:otherwise>
				<li class="page-item " id="page1"><a class="page-link"
					href="?page=${i}">${i}</a></li>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				<c:if test="${currentPage < totalPages}">
				<li class="page-item" id="nextPage"><a class="page-link"
					href="?page=${currentPage + 1}">Trang sau</a></li>
				</c:if>
			</ul>
		</nav>
		</div>
		<!-- container.// -->



	</section>
	<!-- section-content.// -->
	 <div class="container mt-3">
        <c:if test="${not empty sessionScope.msg}">
            <div class="toast align-items-center bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast">
                <div class="d-flex">
                    <div class="toast-body">
                      <p class="text-white">${sessionScope.msg}</p>
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
            </div>

            <script>
                document.addEventListener("DOMContentLoaded", function() {
                    const toastLiveExample = document.getElementById('liveToast');
                    const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample);
                    toastBootstrap.show();
                    setTimeout(() => {
                        toastBootstrap.hide();
                    }, 1500); // 3 giây
                });
            </script>
           <c:remove var="msg" scope="session" />
        </c:if>
    </div>
	<jsp:include page="_footer.jsp"></jsp:include>

	
</body>

</html>

