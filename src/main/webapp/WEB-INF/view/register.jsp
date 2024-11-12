<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Đăng ký</title>

  	<jsp:include page="_link.jsp"></jsp:include>
</head>

<body>

 <!-- header,navbar start -->
		
		<jsp:include page="_header.jsp"/>
		<jsp:include page="_navbar.jsp"/>
<!-- header,navbar end -->

  

  <section class="section-content" style="margin: 100px 0;">
    <div class="card mx-auto" style="max-width: 380px">
      <div class="card-body">
        <h4 class="card-title mb-4">Đăng ký</h4>
        <form action="/register" method="post" id="FormRegister">
          <div class="mb-3">
            <label for="inputUsername" class="form-label">Tên đăng nhập</label>
            <input type="text" class="form-control" id="inputUsername">
          </div>
          <div class="mb-3">
            <label for="inputName" class="form-label">Họ tên</label>
            <input type="text" class="form-control" id="inputName">
          </div>
          <div class="mb-3">
            <label for="inputEmail" class="form-label">Email</label>
            <input type="email" class="form-control" id="inputEmail">
          </div>
          <div class="mb-3">
            <label for="inputPhoneNumber" class="form-label">Số điện thoại</label>
            <input type="number" class="form-control" id="inputPhoneNumber">
          </div>
      
          <div class="mb-3">
            <label for="inputAddress" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="inputAddress">
          </div>
          <div class="mb-3">
            <label for="inputPassword" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="inputPassword">
          </div>
          <div class="mb-3 form-check">
            <input class="form-check-input" type="checkbox" value="" id="checkboxPolicy" checked>
            <label class="form-check-label" for="checkboxPolicy">Đồng ý với <a href="#">điều khoản sử
                dụng</a></label>
          </div>
          <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
        </form>
      </div> <!-- card-body.// -->
    </div> <!-- card.// -->
    <p class="text-center mt-4">Đã có tài khoản? <a href="#">Đăng nhập</a></p>
  </section> <!-- section-content.// -->

  <jsp:include page="_footer.jsp"></jsp:include>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>