<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
   
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   <jsp:include page ="_link.jsp"/>
</head>
<body>
<!-- header,navbar start -->
		<jsp:include page="_header.jsp"/>
    
    <section class="section-content" style="margin: 100px 0;">
        <div class="card mx-auto" style="max-width: 350px">
            <div class="card-body">
                <h4 class="card-title mb-4">Đăng nhập</h4>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="mb-3">
                        <input name="username" class="form-control" placeholder="Tên đăng nhập" type="text"
                            autocomplete="off">
                            
                            <span class="text-danger">${errorUsername}</span>
                            
                    </div>
                    <div class="mb-3">
                        <input name="password" class="form-control" placeholder="Mật khẩu" type="password"
                            autocomplete="off">
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
                </form>
            </div> <!-- card-body.// -->
        </div> <!-- card .// -->
        <p class="text-center mt-4">Không có tài khoản? <a href="#">Đăng ký</a></p>
    </section> <!-- section-content.// -->
	<jsp:include page="_footer.jsp"/>



</body>
</html>