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
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a class="text-decoration-none"
						href="${pageContext.request.contextPath}/admin">Trang chủ</a></li>
					<li class="breadcrumb-item ">Sản phẩm</li>
					<li class="breadcrumb-item active">Cập nhật</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<div class="d-flex justify-content-between">
			<span class="fs-3 text-primary">Cập nhật sản phẩm</span> <a
				class="btn btn-primary">Quay lại</a>
		</div>
		<hr>
		<form class="row" method="post">
			<div class="col-md-6 col-12 ">
				<label class="form-label">Tên sản phẩm</label> <input
					class="form-control">
			</div>
			<div class="col-md-6 col-12 ">
				<label class="form-label">Mô tả</label> <input class="form-control">
			</div>
			<div class="col-md-6 col-12 ">
				<label class="form-label">Giá</label> <input class="form-control"
					type="number">
			</div>
			<div class="col-md-6 col-12 ">
				<label class="form-label">Thông số</label> <input
					class="form-control">
			</div>
			<div class="mb-3 col-12 ">
				<label class="form-lable">Mô tả chi tiết</label>
				<textarea class="form-control"></textarea>
			</div>
			<div class="col-md-6 col-12 ">
				<label class="form-label">Số lượng</label> <input
					class="form-control">
			</div>
			<div class="col-md-6 col-12 ">
				<label class="form-label">Giá khuyến mãi</label> <input
					class="form-control" type="number">
			</div>
			<div class="col-md-4 col-12">
				<label class="form-label">Hãng</label> <select class="form-select"
					aria-label="Default select example">
					<option class="hover-primary" selected>Apple</option>
					<option class="hover-primary" value="1">SamSung</option>
					<option class="hover-primary" value="2">Vivo</option>
					<option class="hover-primary" value="3">Xiaomi</option>
					<option class="hover-primary" value="4">Realme</option>
					<option class="hover-primary" value="5">Oppo</option>
				</select>
			</div>
			<div class="col-md-4 col-12">
				<label class="form-label ">Chuyên dùng</label> <select
					class="form-select">
					<option selected>Gaming</option>
					<option class="hover-primary" value="1">Văn phòng</option>
					<option class="hover-primary" value="2">Doanh nhân</option>
					<option class="hover-primary" value="3">Mỏng nhẹ</option>
					<option class="hover-primary" value="4">Đồ họa</option>
					<option class="hover-primary" value="5">Giá rẻ</option>
				</select>
			</div>
			<div class="col-md-4 col-12">
				<label class="form-label">Ảnh</label> <input type="file"
					class="form-control">
			</div>
		</form>


		<br> <br>

	</main>
	<!-- End #main -->
	<jsp:include page="../layout/_footer.jsp"></jsp:include>
</body>
</html>
tml>
