<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<header class="section-header">
    <section class="header-main border-bottom">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-3 py-3">
            <a class="text-body" href="${pageContext.request.contextPath}">
              <h3>Phone Shop</h3>
            </a>
          </div> <!-- col.// -->
          <div class="col-lg-4 col-xl-5">
            <form action="#" class="search">
              <div class="input-group w-100">
                <input type="text" class="form-control" placeholder="Nhập từ khóa cần tìm ...">
                <button class="btn btn-primary" type="button">
                  <i class="bi bi-search"></i>
                </button>
              </div>
            </form>
          </div> <!-- col.// -->
          <div class="col-lg-5 col-xl-4">
            <ul class="nav col-12 col-lg-auto my-2 my-lg-0 justify-content-center justify-content-lg-end text-small">
              <li>
                <a href="#" class="nav-link text-body">
                  <i class="bi bi-person d-block text-center fs-3"></i>
                  Tài khoản
                </a>
              </li>
              <li>
                <a href="#" class="nav-link text-body">
                  <i class="bi bi-list-check d-block text-center fs-3"></i>
                  Đơn hàng
                </a>
              </li>
              <li style="position: relative;">
                <a href="#" class="nav-link text-body">
                  <i class="bi bi-cart d-block text-center fs-3"></i>
                  Giỏ hàng
                  <span class="cart-count" id="cartCount">3</span>
                </a>
              </li>
            </ul>
          </div> <!-- col.// -->
        </div> <!-- row.// -->
      </div> <!-- container.// -->
    </section> <!-- header-main.// -->
  </header> <!-- section-header.// -->
