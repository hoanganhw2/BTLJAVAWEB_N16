<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../layout/_link.jsp"></jsp:include>
<title>Quản lý sản phẩm</title>

</head>
<body>
	<jsp:include page="../layout/_header.jsp" />
	<jsp:include page="../layout/_sildebar.jsp" />
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
										<tr>
											<td>Unity Pugh</td>
											<td>9958</td>
											<td><img
												src="${pageContext.request.contextPath}/img/iphone.jpg"
												style="max-height: 48px"></td>
											<td>2005/02/11</td>
											<td class="justify-content-arround"><a class="btn"
												href="${pageContext.request.contextPath}/admin/product/1"><img
													src="${pageContext.request.contextPath}/img/xem.png">
											</a> <a class="btn"
												href="${pageContext.request.contextPath}/admin/product/update"><img
													src="${pageContext.request.contextPath}/img/edit.png">
											</a> <a class="btn"
												href="${pageContext.request.contextPath}/admin/product/delete?ma=1"><img
													src="${pageContext.request.contextPath}/img/delete.png">
											</a></td>
										</tr>
										<tr>
											<td>Unity Pugh</td>
											<td>9958</td>
											<td>Curicó</td>
											<td>2005/02/11</td>
											<td class="justify-content-arround"><a class="btn"
												href="${pageContext.request.contextPath}/product/1"><img
													src="../img/xem.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/edit.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/delete.png"> </a></td>
										</tr>
										<tr>
											<td>Unity Pugh</td>
											<td>9958</td>
											<td>Curicó</td>
											<td>2005/02/11</td>
											<td class="justify-content-arround"><a class="btn"
												href="${pageContext.request.contextPath}/product/1"><img
													src="../img/xem.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/edit.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/delete.png"> </a></td>
										</tr>
										<tr>
											<td>Unity Pugh</td>
											<td>9958</td>
											<td>Curicó</td>
											<td>2005/02/11</td>
											<td class="justify-content-arround"><a class="btn"
												href="${pageContext.request.contextPath}/product/1"><img
													src="../img/xem.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/edit.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/delete.png"> </a></td>
										</tr>
										<tr>
											<td>Unity Pugh</td>
											<td>9958</td>
											<td>Curicó</td>
											<td>2005/02/11</td>
											<td class="justify-content-arround"><a class="btn"
												href="${pageContext.request.contextPath}/product/1"><img
													src="../img/xem.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/edit.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/delete.png"> </a></td>
										</tr>
										<tr>
											<td>Unity Pugh</td>
											<td>9958</td>
											<td>Curicó</td>
											<td>2005/02/11</td>
											<td class="justify-content-arround"><a class="btn"
												href="${pageContext.request.contextPath}/product/1"><img
													src="../img/xem.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/edit.png"> </a> <a class="btn"
												href="${pageContext.request.contextPath}/product/2"><img
													src="../img/delete.png"> </a></td>
										</tr>
									</tbody>
								</table>
								<!-- End Table with stripped rows -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		</div>
		<!-- row.// -->
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<li class="page-item" id="prevPage"><a class="page-link"
					href="#">Trang trước</a></li>
				<li class="page-item active" id="page1"><a class="page-link"
					href="#">1</a></li>
				<li class="page-item" id="page2"><a class="page-link" href="#">2</a></li>
				<li class="page-item" id="page3"><a class="page-link" href="#">3</a></li>
				<li class="page-item" id="nextPage"><a class="page-link"
					href="#">Trang sau</a></li>
			</ul>
		</nav>
		</div>
		<!-- container.// -->
	</main>
	<!-- End #main -->
	<jsp:include page="../layout/_footer.jsp"></jsp:include>
</body>
</html>