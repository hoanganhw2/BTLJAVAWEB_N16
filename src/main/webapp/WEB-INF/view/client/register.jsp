<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<jsp:include page="_link.jsp" />
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>

	<section class="section-content" style="margin: 100px 0;">
		<div class="card mx-auto" style="max-width: 400px;">
			<div class="card-body">
				<h4 class="card-title mb-4">Đăng ký</h4>
				<form method="post" action="${pageContext.request.contextPath}/register">
					<div class="mb-2">
						<label class="form-label justify-content-between" for="username">Tên
							đăng nhập<span class="text-danger">*</span>
						</label> <input class="form-control ${not empty errors['errorName'] ? 'is-invalid' : ''}" type="text" id="username"
							name="username" />
							<span class="text-danger">
      				<c:out value="${errors['errorName']}"/>
    			</span>
					</div>
					<div class="mb-2">
						<label class="form-label" for="userpass">Mật khẩu <span
							class="text-danger">*</span></label> <input  type="password" class="form-control ${not empty errors['errorPass'] ? 'is-invalid' : ''}"
							id="userpass" name="userpass"  >
							<span class="text-danger">
      				<c:out value="${errors['errorPass']}"/>
    			</span>
					</div>
					<div class="mb-2">
						<label class="form-label" for="hoten">Họ tên <span
							class="text-danger">*</span></label> <input class="form-control ${not empty errors['errorFullname'] ? 'is-invalid' : ''}"  
							id="hoten" name="userfullname">
							<span class="text-danger">
      				<c:out value="${errors['errorFullname']}"/>
    			</span>
					</div>
					<div class="mb-2 d-flex justify-content-around">
						<div class="form-check me-2">
							<label class="form-check-label" for="nam" ></label> <input value="Nam"
								class="form-check-input" type="radio" name="usergender" id="nam"
								checked> Nam
						</div>
						<div class="form-check me-2">
							<label class="form-check-label" for="nu" ></label> <input value="Nữ"
								class="form-check-input" id="nu" type="radio" name="usergender"> Nữ
						</div>
					</div>
					<div class="mb-2">
						<label class="form-label" for="email">Email<span
							class="text-danger">*</span></label> <input class="form-control ${not empty errors['errorEmail'] ? 'is-invalid' : ''}" placeholder="abc@gmail.com"
							id="email" name="useremail" >
							<span class="text-danger">
      				<c:out value="${errors['errorEmail']}"/>
    			</span>
					</div>
					<div class="mb-2">
						<label class="form-label" for="phone">Số điện thoại<span
							class="text-danger">*</span></label> <input class="form-control ${not empty errors['errorPhone'] ? 'is-invalid' : ''}" 
							id="phone" name="userphone">
							<span class="text-danger">
      				<c:out value="${errors['errorPhone']}"/>
    			</span>
					</div>
					<div class="mb-2">
						<label class="form-label" for="address">Địa chỉ<span
							class="text-danger">*</span></label> <input class="form-control ${not empty errors['errorAddress'] ? 'is-invalid' : ''}" 
							id="address" name="useraddress">
							<span class="text-danger">
      				<c:out value="${errors['errorAddress']}"/>
    			</span>
					</div>
					<div class="mb-2 justify-content-center">
						<input type="submit" class="btn btn-primary w-100" value="Dăng Ký">
					</div>

				</form>

			</div>
		</div>
		<p class="text-center mt-4">
			Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
		</p>
	</section>
	
	<jsp:include page="_footer.jsp" />

</body>
</html>