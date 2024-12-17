<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside id="sidebar" class="sidebar">
	<ul class="sidebar-nav" id="sidebar-nav">
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/admin"> <i
				class="bi bi-grid"></i> <span>Dashboard</span>
		</a></li>
		<!-- End Dashboard Nav -->

		<li class="nav-item">
			<ul id="components-nav" class="nav-content collapse"
				data-bs-parent="#sidebar-nav">
			</ul>
		</li>
		<!-- End Components Nav -->

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#tables-nav"
			href="${pageContext.request.contextPath}/admin/product"> <i
				class="bi bi-box"></i><span>Sản phẩm</span>
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#tables-nav"
			href="${pageContext.request.contextPath}/admin/order"> <i
				class="bi bi-journal-text"></i><span>Đơn hàng</span>
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#tables-nav"
			href="${pageContext.request.contextPath}/admin/user"> <i
				class="bi bi-person-fill"></i><span>Khách hàng</span>
		</a></li>

	</ul>
</aside>