<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>${pageContext.request.contextPath}</title>

  <link href="${pageContext.request.contextPath}/img/favicon.ico" rel="shortcut icon" type="image/x-icon">

  <!-- Bootstrap v5.0.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Bootstrap Icons v1.5.0 -->
  <link href="${pageContext.request.contextPath}/css/bootstrap-icons.css" type="text/css" rel="stylesheet">

  <!-- Custom Styles -->
  <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet">
</head>

<body>
	<!-- link header và navbar - start -->
	<jsp:include page="_header.jsp"/>
	<jsp:include page="_navbar.jsp"/>
	<!-- link header và navbar -ednd -->
  
  <section class="section-content mb-2">
    <div class="container">
      <header class="section-heading py-4 d-flex justify-content-between">
        <h3 class="section-title">Danh mục sản phẩm</h3>
        <a class="btn btn-secondary" href="#" role="button" style="height: fit-content;">Xem tất cả</a>
      </header> <!-- section-heading.// -->
      <div class="row item-grid">
        <div class="col-lg-3 col-md-6">
          <div class="card mb-4">
            <div class="card-body">
              <a href="#" class="stretched-link">
                <div class="d-flex align-items-center">
                  <img src="img/category_apple.png" class="category-img">
                  <span class="category-title ms-3  fs-5 text-dark">Apple(Iphone)</span>
                </div>
              </a>
            </div>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card mb-4">
            <div class="card-body">
              <a href="#" class="stretched-link">
                <div class="d-flex align-items-center">
                  <img src="img/category_samsung.png" class="category-img">
                  <span class="category-title ms-3 fs-5 text-dark ">SamSung</span>
                </div>
              </a>
            </div>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card mb-4">
            <div class="card-body">
              <a href="#" class="stretched-link">
                <div class="d-flex align-items-center">
                  <img src="img/category_oppo.png" class="category-img">
                  <span class="category-title ms-3  fs-5 text-dark">OPPO</span>
                </div>
              </a>
            </div>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card mb-4">
            <div class="card-body">
              <a href="#" class="stretched-link">
                <div class="d-flex align-items-center">
                  <img src="img/category_xiaomi.png" class="category-img">
                  <span class="category-title ms-3  fs-5 text-dark">Xiaomi</span>
                </div>
              </a>
            </div>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card mb-4">
            <div class="card-body">
              <a href="#" class="stretched-link">
                <div class="d-flex align-items-center">
                  <img src="img/category_realme.png" class="category-img">
                  <span class="category-title ms-3  fs-5 text-dark">Realme</span>
                </div>
              </a>
            </div>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card mb-4">
            <div class="card-body">
              <a href="#" class="stretched-link">
                <div class="d-flex align-items-center">
                  <img src="img/category_honor.png" class="category-img">
                  <span class="category-title ms-3  fs-5 text-dark">Honor</span>
                </div>
              </a>
            </div>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card mb-4">
            <div class="card-body">
              <a href="#" class="stretched-link">
                <div class="d-flex align-items-center">
                  <img src="img/category_vivo.png" class="category-img">
                  <span class="category-title ms-3  fs-5 text-dark">Vivo</span>
                </div>
              </a>
            </div>
          </div>
        </div> <!-- col.// -->

      </div> <!-- row.// -->
    </div> <!-- container.// -->
  </section> <!-- section-content.// -->

  <section class="section-content mb-5">
    <div class="container">
      <header class="section-heading py-4 d-flex justify-content-between">
        <h3 class="section-title">Sản phẩm mới nhất</h3>
        <a class="btn btn-secondary" href="#" role="button" style="height: fit-content;">Xem tất cả</a>
      </header> <!-- section-heading.// -->
      <div class="row item-grid ">
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img" src="img/iphone.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Iphone 14</a>
              <div class="price mt-1 fw-bold fs-5"><span class="text-danger">20.900.000đ</span></div>
              <a href="#" class="btn btn-success mt-2 add-to-cart  "><i class="bi bi-cart"></i>Thêm
                vào giỏ hàng</a>

            </figcaption>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img" src="img/galaxy-tab9.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Galaxy tab S9</a>
              <div class="price mt-1 fw-bold fs-5 "><span class="text-danger">19.450.000₫</span></div>
              <a href="/add-product" class="btn btn-success mt-2 "><i class="bi bi-cart"></i>Thêm vào giỏ hàng</a>
            </figcaption>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img" src="img/iphone.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Iphone 14</a>
              <div class="price mt-1 fw-bold fs-5 text-danger">19.450.000₫</div>
              <a href="/add-product" class="btn btn-success mt-2 "><i class="bi bi-cart"></i>Thêm vào giỏ hàng</a>
            </figcaption>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img" src="img/iphone.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Iphone 14</a>
              <div class="price mt-1 fw-bold fs-5 text-danger">19.450.000₫</div>
              <a href="/add-product" class="btn btn-success mt-2 "><i class="bi bi-cart"></i>Thêm vào giỏ hàng</a>
            </figcaption>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img" src="img/iphone.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Iphone 14</a>
              <div class="price mt-1 fw-bold fs-5 text-danger">19.450.000₫</div>
              <a href="/add-product" class="btn btn-success mt-2 "><i class="bi bi-cart"></i>Thêm vào giỏ hàng</a>
            </figcaption>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img" src="img/iphone.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Iphone 14</a>
              <div class="price mt-1 fw-bold fs-5 text-danger">19.450.000₫</div>
              <a href="/add-product" class="btn btn-success mt-2 "><i class="bi bi-cart"></i>Thêm vào giỏ hàng</a>
            </figcaption>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img" src="img/iphone.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Iphone 14</a>
              <div class="price mt-1 fw-bold fs-5 text-danger">19.450.000₫</div>
              <a href="/add-product" class="btn btn-success mt-2 "><i class="bi bi-cart"></i>Thêm vào giỏ hàng</a>
            </figcaption>
          </div>
        </div> <!-- col.// -->
        <div class="col-lg-3 col-md-6">
          <div class="card p-3 mb-4 text-center">
            <a href="#" class="img-wrap text-center">
              <img class="img-fluid product-img " src="img/iphone.jpg">
            </a>
            <figcaption class="info-wrap mt-2 ">
              <a href="#" class="title fs-4 fw-bold">Iphone 14</a>
              <div class="price mt-1 fw-bold fs-5 text-danger">19.450.000₫</div>
              <a href="/add-product" class="btn btn-success mt-2 "><i class="bi bi-cart"></i>Thêm vào giỏ hàng</a>
            </figcaption>
          </div>
        </div> <!-- col.// -->
        <!-- col.// -->

      </div> <!-- row.// -->
      <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
          <li class="page-item" id="prevPage">
            <a class="page-link" href="#">Trang trước</a>
          </li>
          <li class="page-item active" id="page1"><a class="page-link" href="#">1</a></li>
          <li class="page-item" id="page2"><a class="page-link" href="#">2</a></li>
          <li class="page-item" id="page3"><a class="page-link" href="#">3</a></li>
          <li class="page-item" id="nextPage">
            <a class="page-link" href="#">Trang sau</a>
          </li>
        </ul>
      </nav>
    </div> <!-- container.// -->



  </section> <!-- section-content.// -->

  <jsp:include page="_footer.jsp"></jsp:include>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>

</html>
 
       