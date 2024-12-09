<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<jsp:include page="_link.jsp" />
</head>
<body>
	<!-- header,navbar start -->
	<jsp:include page="_header.jsp" />

	<section class="section-content" style="margin: 100px 0;">
		<div class="card mx-auto" style="max-width: 350px">
			<div class="card-body">
				<h4 class="card-title mb-4">Đăng nhập</h4>
				<c:if test="${not empty error }">
					<div class="alert alert-danger" role="alert">
  							<c:out value="${error}"></c:out>
					</div>
				</c:if>		
				<form action="${pageContext.request.contextPath}/login"
					method="post">
					<div class="mb-3">
						<input name="username" class="form-control"
							placeholder="Tên đăng nhập" type="text" autocomplete="off">

						<span class="text-danger">${errorUsername}</span>

					</div>
					<div class="mb-3">
						<input name="password" class="form-control" placeholder="Mật khẩu"
							type="password" autocomplete="off">
					</div>
					<button type="submit" class="btn btn-primary w-100">Đăng
						nhập</button>
				</form>
			</div>
			<!-- card-body.// -->
		</div>
		<!-- card .// -->
		<p class="text-center mt-4">
			Không có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
		</p>
	</section>
	
	<div class="container mt-3">
        <c:if test="${not empty sessionScope.msg}">
            <div class="toast align-items-center bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast">
                <div class="d-flex">
                    <div class="toast-body">
                      <p class="text-white">${sessionScope.msg}</p>
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                </div>
            </div>

            <script>
                document.addEventListener("DOMContentLoaded", function() {
                    const toastLiveExample = document.getElementById('liveToast');
                    const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample);
                    toastBootstrap.show();
                    setTimeout(() => {
                        toastBootstrap.hide();
                    }, 1500); // 3 giây
                });
            </script>
           <c:remove var="msg" scope="session" />
        </c:if>
        </div>
	<!-- section-content.// -->
	<jsp:include page="_footer.jsp" />



</body>
</html>