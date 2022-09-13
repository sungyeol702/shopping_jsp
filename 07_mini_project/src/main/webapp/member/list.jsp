<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
  <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="./home.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./shop.html">Shop</a>
                        <span>Shopping Cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>name</th>
                                    <th>address</th>
                                    <th>grade</th>
                                    <th>last_login</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="mvo" items="${list }">
                                <tr>
                                    <td ><a href="/mem/detail?em=${mvo.id }">${mvo.id }</a></td>
                                    <td >${mvo.name }</td>
                                    <td >${mvo.address }</td>
                                    <td >${mvo.grade }</td>
                                    <td >${mvo.last_login }</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                   
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->


<jsp:include page="../footer.jsp"/>