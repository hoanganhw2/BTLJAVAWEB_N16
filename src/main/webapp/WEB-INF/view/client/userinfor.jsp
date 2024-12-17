<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
<jsp:include page="_link.jsp" />
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container py-5">
    <div class="row">
        <!-- Sidebar với avatar và menu -->
        <div class="col-lg-3">
            <div class="card">
                <div class="card-body text-center">
                    <img src="img/iphone.jpg" class="rounded-circle img-fluid mb-3" style="width: 150px;">
                    <h5 class="card-title">${userInfor.user_fullname}</h5>
                  
                    <div class="list-group mt-3">
                        <a href="#" class="list-group-item list-group-item-action active">
                            <i class="fas fa-user me-2"></i> Thông tin cá nhân
                        </a>
                        <a href="#" class="list-group-item list-group-item-action">
                            <i class="fas fa-shopping-cart me-2"></i> Đơn hàng
                        </a>
                        <a href="#" class="list-group-item list-group-item-action">
                            <i class="fas fa-heart me-2"></i> Yêu thích
                        </a>
                        <a href="#" class="list-group-item list-group-item-action">
                            <i class="fas fa-cog me-2"></i> Cài đặt
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Thông tin chi tiết -->
        <div class="col-lg-9">
            <div class="card">
                <div class="card-header bg-white">
                    <h4 class="mb-0">Thông tin cá nhân</h4>
                </div>
                <div class="card-body">
                    <div class="row mb-4">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Họ và tên</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                        <c:out value="${userInfor.user_fullname}"></c:out>
                        </div>
                    </div>
                    
                    <div class="row mb-4">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Email</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                             <c:out value="${userInfor.user_email}"></c:out>
                        </div>
                    </div>
                    
                    <div class="row mb-4">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Số điện thoại</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            <c:out value="${userInfor.user_phone}"></c:out>
                        </div>
                    </div>
                    
                    <div class="row mb-4">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Địa chỉ</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            <c:out value="${userInfor.user_address}"></c:out>
                        </div>
                    </div>
                    
                    <div class="row mb-4">
                        <div class="col-sm-3">
                            <h6 class="mb-0">Giới tính</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                            <c:if test="${userInfor.user_gender eq 1}">
                            	Nam
                            </c:if>
                            <c:if test="${userInfor.user_gender eq 0}">
                            	Nữ
                            </c:if>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <button class="btn btn-primary me-2">
                                <i class="fas fa-edit me-2"></i>Chỉnh sửa
                            </button>
                            <button class="btn btn-outline-danger">
                                <i class="fas fa-key me-2"></i>Đổi mật khẩu
                            </button>
                        </div>
                    </div>
                </div>
            </div>

          
        </div>
    </div>
</div>
<jsp:include page="_footer.jsp"/>
</body>
</html>