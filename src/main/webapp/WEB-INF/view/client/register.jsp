<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<jsp:include page="_link.jsp"/>
</head>
<body>

	
	<section class="section-content" style="margin: 100px 0;">
    <div class="card mx-auto" style="max-width: 400px;">
        <div class="card-body">
            <h4 class="card-title mb-4">Đăng ký</h4>
            <form>
                <div class="mb-2">
                    <label class="form-label justify-content-between" for="username">Tên đăng nhập<span
                            class="text-danger">*</span></label>
                    <input class="form-control " type="text" id="username" name="username" required />
                </div>
                <div class="mb-2">
                    <label class="form-label" for="userpass">Mật khẩu <span class="text-danger">*</span></label>
                    <input class="form-control" id="userpass" name="userpass" type="password " required>
                </div>
                <div class="mb-2">
                    <label class="form-label" for="hoten">Họ tên <span class="text-danger">*</span></label>
                    <input class="form-control" id="hoten" name="userfullname">
                </div>
                <div class="mb-2 d-flex justify-content-around">
                    <div class="form-check me-2">
                        <label class="form-check-label" for="nam">Nam</label>
                        <input class="form-check-input" type="radio" name="usergender" id="nam" checked>
                    </div>
                    <div class="form-check me-2">
                        <label class="form-check-label" for="nu">Nữ</label>
                        <input class="form-check-input" id="nu" type="radio" name="usergender">
                    </div>
                </div>
                <div class="mb-2">
                    <label class="form-label" for="email">Email<span class="text-danger">*</span></label>
                    <input class="form-control" id="email" name="useremail " type="email">
                </div>
                <div class="mb-2">
                    <label class="form-label" for="phone">Số điện thoại<span class="text-danger">*</span></label>
                    <input class="form-control" id="email" name="userphone">
                </div>
                <div class="mb-2">
                    <label class="form-label" for="address">Địa chỉ<span class="text-danger">*</span></label>
                    <input class="form-control" id="address" name="useraddress">
                </div>
                <div class="mb-2 justify-content-center">
                    <input type="submit" class="btn btn-primary w-100" value="Dăng Ký">
                </div>
        
        </form>

    </div>
    </div>
    <p class="text-center mt-4">Đã có tài khoản? <a href="#">Đăng nhập</a></p>
</section>
	<jsp:include page ="_footer.jsp"/>

</body>
</html>