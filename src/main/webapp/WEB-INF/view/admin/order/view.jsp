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
 <main id="main" class="main">

		<div class="pagetitle">
			<h1>Quản lý đơn hàng</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="${pageContext.request.contextPath}/admin">Trang chủ</a></li>
					<li class="breadcrumb-item">Đơn hàng</li>
					<li class="breadcrumb-item active">Xem chi tiết</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<div class="d-flex justify-content-between">
			<span class="fs-3 text-primary">Xem chi tiết đơn hàng</span>
		</div>
		<hr>
		 <section class="section-content padding-y">
    <div class="container">
      

       

          <article class="card mb-4">

            <header class="card-header">
              <strong class="d-inline-block me-4">${order.order_id}</strong>
              <span>${order_creatAt}</span>
            </header> <!-- card-header.// -->

            <div class="card-body pb-0">
              <div class="row">
                <div class="col-lg-8">
                  <h6 class="text-muted">Địa chỉ người nhận</h6>
                  <p class="lh-lg">Người nhận
                  	<sapn class="fw-bold">${order.order_fullname}</sapn>
                    <br>
                    Số điện thoại: <c:out value="${order.order_phone}"></c:out><br>
                    Địa chỉ: <c:out value="${order.order_address}"></c:out>
                  </p>
                </div>
                <div class="col-lg-4">
                  <h6 class="text-muted">Hình thức thanh toán</h6>
                  <span class="text-success">
                    <i class="fab fa-lg fa-cc-visa"></i>
                   <c:choose>
                   		<c:when test="${order.order_delivery eq 1 }">
                   				Giao tiêu chuẩn
                   		</c:when>
                   		<c:when test="${order.order_delivery eq 2}">
                   			Giao nhanh
                   		</c:when>
                   </c:choose>
                  </span>
                  <p class="lh-lg">
                    Tạm tính: <fmt:formatNumber type="number" value="${total}" />
                                                            VND<br>
                    Phí vận chuyển: <c:out value="${delivery}"></c:out><br>
                    <strong>Tổng cộng:
                    <fmt:formatNumber type="number" value="${total + delivery}"/>
                                                            VND<br></strong>
                  </p>
                </div>
              </div> <!-- row.// -->
            </div> <!-- card-body.// -->

            <hr class="m-0">

            <div class="table-responsive">
              <table class="cart-table table table-borderless">
                <thead class="text-muted">
                  <tr class="small text-uppercase">
                    <th scope="col" style="min-width: 280px;">Sản phẩm</th>
                    <th scope="col" width="150" style="min-width: 150px;">Giá</th>
                    <th scope="col" width="150" style="min-width: 150px;">Số lượng</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="x" items="${orderitems}">
                  <tr>
                    <td>
                      <figure class="itemside">
                        <div class="float-start me-3"><img style="max-width: 100px" src="${pageContext.request.contextPath}/img/product/${x.image}"></div>
                        <figcaption class="info">
                          <p class="title fs-4">${x.productname}</p>
                        </figcaption>
                      </figure>
                    </td>
                    <td>
                      <div class="price-wrap">
                        <span class="price">
                        <fmt:formatNumber type="number" value="${x.price}"/>
                                                            VND
                        </span>
                      </div>
                    </td>
                    <td>
                      ${x.quantity}
                    </td>
                  </tr>
                 </c:forEach>
                </tbody>
              </table>
            </div> <!-- table.responsive-md.// -->


          </article>

        

      </div>
  </section>
		
		<!-- row.// -->
		
		
	
		<!-- container.// -->
	</main>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<jsp:include page="../layout/_footer.jsp"></jsp:include>
</body>
</html>