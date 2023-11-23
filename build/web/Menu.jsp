<%-- 
    Document   : Menu
    Created on : Jul 7, 2023, 10:36:21 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">STOCKX</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <!--Goi toi bien acc trong session-->
                <c:if test="${sessionScope.acc == null}"> 
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>
                <!--Goi toi bien acc trong session-->
                <c:if test="${sessionScope.acc != null}"> 
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Profile.jsp">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Welcome ${sessionScope.acc.user}</a>
                    </li>
                </c:if>
                <!--Goi toi bien acc trong session-->
                <c:if test="${sessionScope.acc.isSell == 1}"> 
                    <li class="nav-item">
                        <a class="nav-link" href="managersell">Manage Sell</a>
                    </li>
                </c:if>
                <!--Goi toi bien acc trong session-->
                <c:if test="${sessionScope.acc.isAdmin == 1}"> 
                    <li class="nav-item">
                        <a class="nav-link" href="#">Manage Employee</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="#">News</a>
                </li>
            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="showcart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light"></span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">STOCKX</h1>
        <p class="lead text-muted mb-0">WE HAVE A DEEP, DEEP LOVE FOR SNEAKERS</p>
    </div>
</section>
<!--end of menu-->
