<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"/>

 <!-- Shopping Cart Section Begin -->
<%--  <c:set var="total" value="0"/>  --%>
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th class="p-name">Product Name</th>
                                    <th>Price</th>
                                    <th>addr</th>
                                    <th>buy_date</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            
                             <c:forEach var="buyvo" items="${list }">
                                <tr>
                                    <td class="rb-pic">
                                    <img  src="/resources/dist/img/products/${buyvo.pname }.jpg" alt="">
                                    </td>
                                    <td class="cart-title first-row">
                                        <h5>${buyvo.pname }</h5>
                                    </td>
                                    <td class="p-price first-row">$${buyvo.price }</td>
                                    <td class="qua-col first-row">
                                       ${buyvo.address }
                                    </td>
                                    <td class="total-price first-row">${buyvo.buy_date }</td>
                                    <td ><a class="primary-btn" href= "/rev/register?em=${buyvo.pno }">리뷰쓰기</a></td>
                                </tr>
                                <c:set var="total" value = "${total+ buyvo.price}"/>
                                 </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            
                        </div>
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                <ul>
                                    <li class="cart-total">Total <span>
                                  $${total}
                                    </span></li>
                                </ul>
                             
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->


<jsp:include page="../footer.jsp"/>