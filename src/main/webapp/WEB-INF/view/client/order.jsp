<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>

<title>Đặt hàng</title>
<jsp:include page="_link.jsp" />
<style type="text/css">
tr,th,td{
 	text-align: center;
 }
</style>
</head>
<body>
<jsp:include page="_header.jsp" />
<jsp:include page="_navbar.jsp" />
<section class="section-pagetop bg-light">
    <div class="container">
      <h2 class="title-page">Đơn hàng</h2>
    </div> <!-- container.// -->
  </section> <!-- section-pagetop.// -->

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
                   <div class="d-inline-block">
                    <a class="btn btn-primary me-2" href="${pageContext.request.contextPath}/order/detail?id=${order.order_id}" role="button">Xem đơn hàng</a>
                     <c:if test="${order.order_satuts eq 4 }">
                     <form action="${pageContext.request.contextPath}/order/update" method="post" class="d-inline">
                     
                     <input type="hidden" name="action" value="${order.order_id}">
                     	<input type="submit" class="btn btn-warning me-2" value="Đặt lại đơn hàng">
                     	</form>
                     </c:if>
                     <c:if test="${order.order_satuts eq 1 }">
                     <form action="${pageContext.request.contextPath}/order/cancel" method="post" class="d-inline">
                     
                     <input type="hidden" name="action" value="${order.order_id}">
                     	<input type="submit" class="btn btn-danger me-2" value="Hủy đơn hàng">
                     	</form>
                     </c:if>
                     </div>
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
  </section> <!-- section-content.// -->
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
  <jsp:include page="_footer.jsp" />
</body>
</html>