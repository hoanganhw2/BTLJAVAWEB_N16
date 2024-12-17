<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../layout/_link.jsp"></jsp:include>
<title>Quản lý sản phẩm</title>
	<style type="text/css">
	.hover-primary:hover{
	background-color: #4154f1 !important;
	color:white !important;
}</style>
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
					<li class="breadcrumb-item active">Cập nhật sản phẩm</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<div class="d-flex justify-content-between">
			<span class="fs-3 text-primary">Cập nhật sản phẩm</span> <a
				class="btn btn-primary">Quay lại</a>
		</div>
		
		<hr>
		<form class="row" method="post" action="${pageContext.request.contextPath}/admin/product/update"  enctype="multipart/form-data"  >
			<div class="col-12 mb-2">
				<label class="form-label">ID</label>
				<input class="form-control" name="id" value="${product.product_id}" readonly="readonly">
			</div>
			<div class="col-12 mb-2" style="display: none" >
				<label class="form-label">Image-name</label>
				<input class="form-control" name="product_image" value="${product.product_image}" >
			</div>
			<div class="col-md-6 col-12 mb-2">
				<label class="form-label ">Tên sản phẩm</label> 
				<input type="text" required="required" name="product_name" value="${product.product_name}"
					class="form-control ${not empty errors['errorName'] ? 'is-invalid' : ''}">
					<span class="text-danger">
      				<c:out value="${errors['errorName']}"/>
    		</span>
			</div>
			
			<div class="col-md-6 col-12 mb-2 ">
				<label class="form-label">Giá</label> 
				<input  type="number" class="form-control ${not empty errors['errorPrice'] ? 'is-invalid' : ''}" required="required" name="product_price"
				value="${product.product_price}"	type="number">
					<span class="text-danger">
      				<c:out value="${errors['errorPrice']}"/>
      				</span>
			</div>
			<div class=" col-12 mb-2">
				<label class="form-label">Thông số</label> 
				<input type ="text" required="required" name="product_shortdesc" value="${product.product_shortdesc}"
					class="form-control">
					    				
			</div>
			<div class="mb-3 col-12  mb-2">
				<label class="form-lable">Mô tả chi tiết</label>
				<textarea class="form-control" required="required" name="product_description" >${product.product_description}</textarea>
			</div>
			<div class="col-md-6 col-12 mb-2">
				<label class="form-label">Số lượng</label> <input type="number" required="required" name="product_quantity" value="${product.product_quantity}"
					class="form-control ${not empty errors['Quantity'] ? 'is-invalid' : ''}">
					<span class="text-danger">
      				<c:out value="${errors['errorQuantity']}"/></span>
			</div>
			<div class="col-md-6 col-12 mb-2 ">
				<label class="form-label">Giá khuyến mãi</label> <input required="required" name="product_discount" value="${product.product_discount}"
					class="form-control ${not empty errors['errorDiscount'] ? 'is-invalid' : ''}" type="number">
					<span class="text-danger">
      				<c:out value="${errors['errorDiscount']}"/></span>
			</div>
			<div class="col-md-4 col-12 mb-2 ">
				<label class="form-label">Ảnh</label> <input type="file" name="file"
					class="form-control" id="fileInput" >
			</div>
			<div class="col-md-4 col-12 mb-2">
				<label class="form-label">Hãng</label> <select class="form-select" name="product_category" 
					aria-label="Default select example">
					<c:forEach var="category" items="${categoris}">
						<option class="hover-primary" value="${category.category_id}">${ category.category_name}</option>
					</c:forEach>
					
					
				</select>
			</div>
			<div class="col-md-4 col-12 mb-2">
				<label class="form-label ">Chuyên dùng</label> <select
					class="form-select" name="product_target">
					<option  class="hover-primary"  value="Gaming">Gaming</option>
					<option class="hover-primary" value="Văn phòng">Văn phòng</option>
					<option class="hover-primary" value="Doanh nhân">Doanh nhân</option>
					<option class="hover-primary" value="Mỏng nhẹ">Mỏng nhẹ</option>
					<option class="hover-primary" value="Đồ họa">Đồ họa</option>
					<option class="hover-primary" value="Giá rẻ">Giá rẻ</option>
				</select>
			</div>

			<div class="col-md-4 col-12 text-center mb-2">

				<img class=" rounded" style="max-height:250px;display: none;"
					alt="product image" id="imagePreview" />

			</div>
			
			<div class="text-center ">
				<input class="col-md-4 col-12 btn  btn-primary " value="Cập nhật" 
					type="submit">
			</div>
		</form>


		<br> <br>

	</main>
	<!-- End #main -->
	
		
	<jsp:include page="../layout/_footer.jsp"></jsp:include>

</body>
</html>