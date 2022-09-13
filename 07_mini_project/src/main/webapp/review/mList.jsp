<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<!-- Shopping Cart Section Begin -->
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
                                    <th class="p-name">Title</th>
                                    <th>writer</th>
                                    <th>reg_at</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="rvo" items="${mlist }">
                                <tr>
                                 <c:if test="${not empty rvo.pname }">
                                    <td class="cart-pic first-row"><img src="/_fileUpload/th_${rvo.image_file }" alt=""></td>
                                  </c:if>
                                 <c:if test="${empty rvo.pname }">
                                    <td class="cart-pic first-row">이미지 없음</td>
                                  </c:if>
                                    <td class="cart-title first-row">
                                    <c:if test="${not empty rvo.pname }">
                                        <h5><a href="/prd/detail?pno=${rvo.pno }">${rvo.pname}</a></h5>
                                        </c:if>
                                    <c:if test="${empty rvo.pname }">
                                        <h5>삭제된 상품입니다</h5>
                                        </c:if>
                                    </td>
                                    <td class="cart-title first-row">
                                        <h5><a href="/rev/detail?rno=${rvo.rno }">${rvo.title }</a></h5>
                                    </td>
                                    <td class=" first-row">${rvo.writer }</td>
                                    <td class="total-price first-row">${rvo.reg_at }</td>
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