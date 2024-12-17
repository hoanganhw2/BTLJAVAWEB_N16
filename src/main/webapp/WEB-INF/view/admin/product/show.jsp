<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../layout/_link.jsp"></jsp:include>
<title>Quản lý sản phẩm</title>

</head>
<body>
	<jsp:include page="../layout/_header.jsp" />
	<jsp:include page="../layout/_sildebar.jsp" />
	<div class="toast-container position-fixed top-0 end-0 p-3">
    <c:if test="${not empty sessionScope.update}">
        <div class="toast align-items-center bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast" style="margin-top: 60px">
            <div class="d-flex">
                <div class="toast-body">
                    <p class="text-white mb-0">${sessionScope.update}</p>
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                const toastLiveExample = document.getElementById('liveToast');
                const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample, {
                    // Thêm options cho toast
                    animation: true,
                    autohide: true,
                    delay: 1500
                });
                toastBootstrap.show();
            });
        </script>
        <c:remove var="update" scope="session" />
    </c:if>
</div>
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Quản lý sản phẩm</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/admin">Trang chủ</a></li>
					<li class="breadcrumb-item">Sản phẩm</li>
					<li class="breadcrumb-item active">Danh sách</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<div class="d-flex justify-content-between">
			<span class="fs-3 text-primary">Danh sách sản phẩm</span> <a
				class="btn   "
				href="${pageContext.request.contextPath}/admin/product/add"><img
				src="${pageContext.request.contextPath}/img/add.png"> </a>
		</div>
		<hr>
		<section class="section">
			
			<div class="row">
			
				<div class="col-lg-12">

					<div class="card">
						<div class="card-body">

							<div class="table-responsive">
								<!-- Table with stripped rows -->
								<table class="table  table-hover">
									<thead>
										<tr>
											<th>Mã</th>
											<th>Tên sản phẩm</th>
											<th>Hình ảnh</th>
											<th>Giá</th>
											<th>Hành động</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="product" items="${products}">
										<tr>
											<td>${product.product_id}</td>
											<td>${product.product_name}</td>
											<td><img
												src="${pageContext.request.contextPath}/img/product/${product.product_image}"
												style="max-height: 48px"></td>
											<td>
												<fmt:formatNumber type="number" value="${product.product_price}" />
                                                            VND
											</td>
											<td class="justify-content-arround"><a class="btn"
												href="${pageContext.request.contextPath}/admin/product/view?id=${product.product_id}"><img
													src="${pageContext.request.contextPath}/img/xem.png">
											</a> <a class="btn"
												href="${pageContext.request.contextPath}/admin/product/update?id=${product.product_id}"><img
													src="${pageContext.request.contextPath}/img/edit.png">
											</a> <a class="btn"
												href="${pageContext.request.contextPath}/admin/product/delete?ma=${product.product_id}"><img
													src="${pageContext.request.contextPath}/img/delete.png">
											</a></td>
										</tr>
										</c:forEach>
										
									</tbody>
								</table>
								<!-- End Table with stripped rows -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<!-- row.// -->
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
	</main>
	<!-- End #main -->
	
    <!-- Toast Container -->
    
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<jsp:include page="../layout/_footer.jsp"></jsp:include>
	
	
</body>
</html>