<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../layout/_link.jsp"></jsp:include>
<title>Xóa sản phẩm</title>

</script>
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
					<li class="breadcrumb-item active">Xóa</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<div class="container mt-5">
			<h3>Xóa sản phẩm có id = ${id }</h3>
			<hr>
			<div class="alert alert-warning" role="alert">Bạn có chắc muốn
				xóa sản phẩm này không?</div>
			<form method="post"
				action="${pageContext.request.contextPath}/admin/product/delete">
				<div class="mb-3" style="display: none">
					<label class="label-form">ID</label> <input class="form-control"
						value=${id } type="text">
				</div>
				<input class="btn btn-primary" type="submit" value="Đồng ý">
				<a class="btn btn-success" href="#">Quay lại</a>
			</form>
		</div>


	</main>
	<jsp:include page="../layout/_footer.jsp"></jsp:include>

</body>
</html>