<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta charset="UTF-8">
<title>Danh sách đơn hàng</title>
<jsp:include page="../layout/_link.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../layout/_header.jsp" />

<jsp:include page="../layout/_sildebar.jsp" />
<c:if test="${not empty sessionScope.update}">
        <div class="toast align-items-center bg-success border-0 fixed-top" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast">
    <div class="d-flex">
        <div class="toast-body">
            <p class="text-white mb-0">
            	<c:out value="${sessionScope.update}"></c:out>
            </p>
        </div>
        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
    </div>
</div>
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                const toastLiveExample = document.getElementById('liveToast');
                const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample, {
                    // Thêm options cho toast
                    animation: true,
                    autohide: true,
                    delay: 1500
                });
                toastBootstrap.show();
            });
        </script>
        <c:remove var="update" scope="session" />
    </c:if>
 <main id="main" class="main">

		<div class="pagetitle">
			<h1>Quản lý đơn hàng</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/admin">Trang chủ</a></li>
					<li class="breadcrumb-item">Đơn hàng</li>
					<li class="breadcrumb-item active">Danh sách</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<div class="d-flex justify-content-between">
			<span class="fs-3 text-primary">Danh sách đơn hàng</span>
		</div>
		<hr>
		 <section class="section-content padding-y">
    <div class="container">


          <div class="table-responsive-xxl">
            <table class="table table-bordered table-striped table-hover align-middle">
              <thead>
                <tr>
                  <th scope="col" style="min-width: 125px;">Mã đơn hàng</th>
                  <th scope="col" style="min-width: 100px;">Ngày mua</th>
           
                  <th scope="col" style="min-width: 100px;">Tổng tiền</th>
                  <th scope="col" style="min-width: 175px;">Trạng thái đơn hàng</th>
                  <th scope="col">Thao tác</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach var="order" items="${orders}">
                <tr>
                  <th scope="row">${order.order_id}</th>
                  <td>${order.order_creatAt}</td>
              
                  <td>
						<fmt:formatNumber type="number" value="${order.order_price}" />
                                                            VND
				</td>
                  <td>
                  <c:choose>
                      <c:when test="${order.order_satuts eq 1}">
                         <span class="badge bg-secondary text-white">Chờ xác nhận</span>
                      </c:when>
                      <c:when test="${order.order_satuts eq 2}">
                         <span class="badge bg-warning text-black">Đang giao hàng</span>
                      </c:when>
                      <c:when test="${order.order_satuts eq 3}">
                          <span class="badge bg-success text-white">Giao thành công</span>
                      </c:when>
                      <c:when test="${order.order_satuts eq 4}">
                          <span class="badge bg-danger text-white">Đơn hàng bị hủy</span>
                      </c:when>
                  </c:choose>
                  </td>
                  <td class="text-center text-nowrap">
                    <a class="btn btn-primary me-2" href="${pageContext.request.contextPath}/admin/order/view?id=${order.order_id}" role="button">Xem đơn hàng</a>
                     <a class="btn btn-warning me-2" href="#" role="button" data-bs-toggle="modal" data-bs-target="#updateModal" data-order-id="${order.order_id}">Cập nhật đơn hàng</a>
                  </td>
                </tr>
                </c:forEach>
                
              </tbody>
            </table>
          </div>
    </div>

      <nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<c:if test="${currentPage > 1}">
					<li class="page-item" id="prevPage"><a class="page-link"
					href="?page=${currentPage - 1}">Trang trước</a></li>
				</c:if>
				 <c:forEach begin="1" end="${totalPages}" var="i">
				 <c:choose>
				 <c:when test="${currentPage eq i}">
				<li class="page-item active" id="page1"><a class="page-link"
					href="#">${i}</a></li>
				</c:when>
				<c:otherwise>
				<li class="page-item " id="page1"><a class="page-link"
					href="?page=${i}">${i}</a></li>
				</c:otherwise>
				</c:choose>
				</c:forEach>
				<c:if test="${currentPage < totalPages}">
				<li class="page-item" id="nextPage"><a class="page-link"
					href="?page=${currentPage + 1}">Trang sau</a></li>
				</c:if>
			</ul>
		</nav>
  </section>
		
		<!-- row.// -->
		
		<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateModalLabel">Cập Nhật Trạng Thái Giao Hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="updateForm" action="${pageContext.request.contextPath}/admin/order/update" method="post">
                    <input type="hidden" name="orderId" id="orderId" >
                    <div class="mb-3">
                        <label for="status" class="form-label">Trạng Thái</label>
                        <select name="status" id="status" class="form-select">
                        	<option value="1">Chờ duyệt</option>
                            <option value="2">Đang giao hàng</option>
                            <option value="3">Thành công</option>
                            <option value="4">Hủy đơn hàng</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Cập Nhật</button>
                </form>
            </div>
        </div>
    </div>
</div>
	<script type="text/javascript">
	var updateModal = document.getElementById('updateModal');
    updateModal.addEventListener('show.bs.modal', function (event) {
        var button = event.relatedTarget; // Nút đã nhấn
        var orderId = button.getAttribute('data-order-id'); // Lấy ID đơn hàng từ nút
        var modalOrderIdInput = document.getElementById('orderId');
        modalOrderIdInput.value = orderId; // Cập nhật giá trị ID đơn hàng vào form
    });
	</script>
		<!-- container.// -->
	</main>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<jsp:include page="../layout/_footer.jsp"></jsp:include>
</body>
</html>