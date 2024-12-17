<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

<head>
<meta charset="UTF-8">


<title>Giỏ hàng</title>

<jsp:include page="_link.jsp" />
</head>

<body>

	<jsp:include page="_header.jsp" />
	<jsp:include page="_navbar.jsp"/>
	<section class="section-pagetop bg-light">
		<div class="container">
			<h2 class="title-page">Giỏ hàng</h2>
			<c:if test="${empty cartitems}">
						<p>Bạn chưa mua sản phẩm nào :))</p>
					</c:if>
		</div>
		<!-- container.// -->
		
	</section>
	
	<!-- section-pagetop.// -->
	<c:if test="${not empty cartitems }"> 
	<section class="section-content padding-y">
	
		
		<div class="container">
			<div class="row">

				<main class="col-lg-9 mb-lg-0 mb-3">
					
					
					<div class="card">

						<div class="table-responsive-xl">
						
						<form id="cartForm" action="${pageContext.request.contextPath}/cart/update" method="POST">
    <table  class="table table">
    
    <tr class="text-center">
    	<th>ID</th>
    	<th>Tên sản phẩm</th>
    	<th>Giá</th>
    	<th>Số lượng</th>
    	<th>Hành động</th>
    </tr>
        <c:forEach var="cartitem" items="${cartitems}">
        <tr>
        	<td>${cartitem.product_id}</td>
            <td>
                <figure class="itemside">
                    <div class="float-start me-3">
                        <img src="${pageContext.request.contextPath}/img/product/${cartitem.image}" 
                             style="max-height: 50px">
                    </div>
                    <figcaption class="info">
                        <a href="#" class="title"><c:out value="${cartitem.name}"/></a>
                    </figcaption>
                </figure>
            </td>
            <td>
                <div class="price-wrap">
                    <span class="price">
                        <fmt:formatNumber type="number" value="${cartitem.price}"/> VND
                    </span>
                </div>
            </td>
            <td>
                <input type="number" 
                       name="quantity_${cartitem.id}"
                      value="${cartitem.quantity}"
                       min="1"
                       class="form-control">
            </td>
            <td class="text-center text-nowrap">
                <!-- Nút cập nhật -->
                <button type="submit" 
                        name="action" 
                        value="update_${cartitem.id}_${cartitem.product_id}_${cartitem.cart_id}" 
                        class="btn btn-success">
                    Cập nhật
                </button>
                
                <!-- Nút xóa -->
                <button type="submit" 
                        name="action" 
                        value="delete_${cartitem.id}_${cartitem.product_id}_${cartitem.cart_id}" 
                        class="btn btn-danger ms-1">
                    Xóa
                </button>
            </td>
        </tr>
        </c:forEach>
    </table>
</form>		
</div>
					<!-- card.// -->
				
						<!-- table.responsive-md.// -->
			<form action="${pageContext.request.contextPath}/order" method="post">
						<div class="card-body border-top">
							<input   name="total" value="${totalprice}" type="hidden" >
							
							<input   name="cartid" value="${cartitems[0].cart_id}" type="hidden" >
							<input type="hidden" name="delivery-method" id="delivery-method" value="1"> 
							<input class="btn btn-primary float-end" value="Đặt hàng" type="submit">
							 <a	href="${pageContext.request.contextPath}/" class="btn btn-light">Tiếp tục mua sắm</a>
						</div>
						</form>
						<!-- card-body.// -->
					
					</div>
				</main>
				<!-- col.// -->

				<aside class="col-lg-3">
					
					<div class="card mb-3">
						<div class="card-body">
							<p class="card-title">Hình thức giao hàng</p>
							
								<div class="form-check mb-2">
									<input class="form-check-input" type="radio" 
										name="delivery-method" id="delivery-method-1" value="1" checked="checked"  onchange="updateDeliveryMethod(1)">
									<label class="form-check-label" for="delivery-method-1"  >Giao
										tiêu chuẩn</label>
								</div>
								<div class="form-check mb-2">
									<input class="form-check-input" type="radio"
										name="delivery-method" id="delivery-method-2" value="2" onchange="updateDeliveryMethod(2)">
									<label class="form-check-label" for="delivery-method-2">Giao
										nhanh</label>
								</div>
							<c:set var="delivery" value="${25000}"/>
						</div>
						<!-- card-body.// -->
					</div>
					<!-- card.// -->

					

					<div class="card">
						<div class="card-body">
							<dl class="row mb-0">
								<dt class="col-xxl-6 col-lg-12 col-6">Tạm tính: 			
								</dt>
								<dd class="col-xxl-6 col-lg-12 col-6 text-end mb-3">
									<span id="temp-price"><fmt:formatNumber type="number" value="${totalprice}"/>
                                                            đ</span>
								</dd>
								<dt class="col-xxl-6 col-lg-12 col-6">Phí vận chuyển:</dt>
								<dd class="col-xxl-6 col-lg-12 col-6 text-end mb-3">
									<span id="delivery-price" ><fmt:formatNumber type="number" value="25000"/>
                                                            đ</span>
								</dd>
								<dt class="col-xxl-6 col-lg-12 col-6">Tổng cộng:</dt>
								<dd class="col-xxl-6 col-lg-12 col-6 text-end mb-3">
									<strong><span id="total-price" name="totalprice">
									<fmt:formatNumber type="number" value="${totalprice}"/>
									</span></strong>
								</dd>
							</dl>
						</div>
						
						<!-- card-body.// -->
					</div>
					<!-- card.// -->
			
				</aside>
				<!-- col.// -->
			
			</div>
			<!-- row.// -->
		</div>
		<!-- container -->
			
	</section>
</c:if>
	<!-- section-content.// -->
<script>
function updateDeliveryMethod(value) {
    document.getElementById('delivery-method').value = value; 
}
	
function submitCartForm(action, cartItemId) {
    // Lấy form
    
    
    const form = document.getElementById('cartForm');
    
    // Set action và cartItemId
    document.getElementById('formAction').value = action;
    document.getElementById('selectedCartItemId').value = cartItemId;
    
    // Nếu là update, thêm số lượng vào form
    if (action === 'update') {
        const quantity = document.querySelector(`input[data-cartitem-id="${cartItemId}"]`).value;
        const quantityInput = document.createElement('input');
        quantityInput.type = 'hidden';
        quantityInput.name = 'quantity';
        quantityInput.value = quantity;
        form.appendChild(quantityInput);
    }
    
    // Submit form
    form.submit();
}
</script>
 <c:if test="${not empty sessionScope.msg}">
        <div class="toast align-items-center bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast" style="margin-top: 60px">
            <div class="d-flex">
                <div class="toast-body">
                    <p class="text-white mb-0">${sessionScope.msg}</p>
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
        <c:remove var="msg" scope="session" />
    </c:if>
	
<jsp:include page="_footer.jsp"/>
</body>

</html>