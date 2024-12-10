<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>404 error</title>
<jsp:include page="_link.jsp" />
</head>
<body>
	<div class="text-center">
        <h1 class="display-1">404</h1>
        <p class="lead">Xin lỗi, trang bạn tìm không tồn tại.</p>
        <a href="${pageContext.request.contextPath}/" class="btn btn-primary btn-lg">Quay về trang chính</a>
    </div>
</html>