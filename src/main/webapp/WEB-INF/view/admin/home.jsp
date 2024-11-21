<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />

        <title>Dashboard</title>           
        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect" />
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"
        />

        <!-- Vendor CSS Files -->
       <jsp:include page ="_link.jsp"/>
    </head>

    <body>
        <jsp:include page ="_header.jsp"/>
        <!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">
            <ul class="sidebar-nav" id="sidebar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">
                        <i class="bi bi-grid"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <!-- End Dashboard Nav -->

                <li class="nav-item">                
                    <ul id="components-nav"
                        class="nav-content collapse"
                      data-bs-parent="#sidebar-nav">  
                    </ul>
                </li>
                <!-- End Components Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed"
                    data-bs-target="#tables-nav"
                    data-bs-toggle="collapse" href="#">
                        <i class="bi bi-journal-text"></i><span>Sản phẩm</span > </a>                           
                </li>
				 <li class="nav-item">
                    <a class="nav-link collapsed"
                    data-bs-target="#tables-nav"
                    data-bs-toggle="collapse" href="#">
                        <i class="bi bi-journal-text"></i><span>Đơn hàng</span > </a>                           
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"
                    data-bs-target="#tables-nav"
                    data-bs-toggle="collapse" href="#">
                    <i class="bi bi-question-circle"></i><span>Khách hàng</span></a>   
                </li>
                

            </ul>
        </aside>
        <!-- End Sidebar-->

        <main id="main" class="main">
            <div class="pagetitle">
                <h1>Dashboard</h1>
               
            </div>
            <!-- End Page Title -->

            <section class="section dashboard">
                <div class="row">
                    <!-- Left side columns -->
                    <div class="col-lg-12">
                        <div class="row">
                            <!-- Sales Card -->
                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card sales-card">
                                    <div class="filter">
                                        <a
                                            class="icon"
                                            href="#"
                                            data-bs-toggle="dropdown"
                                            ><i class="bi bi-three-dots"></i
                                        ></a>
                                        <ul
                                            class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                                        >
                                            <li
                                                class="dropdown-header text-start"
                                            >
                                                <h6>Filter</h6>
                                            </li>

                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >Today</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >This Month</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >This Year</a
                                                >
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">
                                            Đơn bán hàng <span>| Hôm nay</span>
                                        </h5>

                                        <div class="d-flex align-items-center">
                                            <div
                                                class="card-icon rounded-circle d-flex align-items-center justify-content-center"
                                            >
                                                <i class="bi bi-cart"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>145</h6>
                                                <span
                                                    class="text-success small pt-1 fw-bold"
                                                    >12%</span
                                                >
                                                <span
                                                    class="text-muted small pt-2 ps-1"
                                                    >Tăng</span
                                                >
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Sales Card -->

                            <!-- Revenue Card -->
                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card revenue-card">
                                    <div class="filter">
                                        <a
                                            class="icon"
                                            href="#"
                                            data-bs-toggle="dropdown"
                                            ><i class="bi bi-three-dots"></i
                                        ></a>
                                        <ul
                                            class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                                        >
                                            <li
                                                class="dropdown-header text-start"
                                            >
                                                <h6>Filter</h6>
                                            </li>

                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >Today</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >This Month</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >This Year</a
                                                >
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">
                                            Doanh thu <span>| Hôm nay</span>
                                        </h5>

                                        <div class="d-flex align-items-center">
                                            <div
                                                class="card-icon rounded-circle d-flex align-items-center justify-content-center"
                                            >
                                                <i
                                                    class="bi bi-currency-dollar"
                                                ></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>$3,264</h6>
                                                <span
                                                    class="text-success small pt-1 fw-bold"
                                                    >8%</span
                                                >
                                                <span
                                                    class="text-muted small pt-2 ps-1"
                                                    >Tăng</span
                                                >
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Revenue Card -->

                            <!-- Customers Card -->
                            <div class="col-xxl-4 col-xl-12">
                                <div class="card info-card customers-card">
                                    <div class="filter">
                                        <a
                                            class="icon"
                                            href="#"
                                            data-bs-toggle="dropdown"
                                            ><i class="bi bi-three-dots"></i
                                        ></a>
                                        <ul
                                            class="dropdown-menu dropdown-menu-end dropdown-menu-arrow"
                                        >
                                            <li
                                                class="dropdown-header text-start"
                                            >
                                                <h6>Filter</h6>
                                            </li>

                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >Today</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >This Month</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    class="dropdown-item"
                                                    href="#"
                                                    >This Year</a
                                                >
                                            </li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">
                                            Khách hàng <span>| Hôm nay</span>
                                        </h5>

                                        <div class="d-flex align-items-center">
                                            <div
                                                class="card-icon rounded-circle d-flex align-items-center justify-content-center"
                                            >
                                                <i class="bi bi-people"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>1244</h6>
                                                <span
                                                    class="text-danger small pt-1 fw-bold"
                                                    >12%</span
                                                >
                                                <span
                                                    class="text-muted small pt-2 ps-1"
                                                    >Giảm</span
                                                >
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Customers Card -->

                            <!-- Reports -->
                        
        </main>
        <!-- End #main -->
	<jsp:include page ="_footer.jsp"/>
    </body>
</html>
    