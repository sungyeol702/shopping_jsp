<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<section class="shopping-cart spad">
        <div class="container">
        <div class="container">
      <div class="inner-header">
        <div class="row">
          <div class="col-lg-2 col-md-2">
            <div class="logo">
              <a href="/"> <img src="img/logo.png" alt="">
              </a>
            </div>
          </div>
          <div class="col-lg-7 col-md-7">
          <form action="/brd/search" method="post" >
            <div class="advanced-search">
              <select  class="category-btn" name="keyword_scope">
              <option value="title">제목</option>
              <option value="all">제목+내용</option>
                </select>
              <div class="input-group">
                <input type="text" name="keyword" placeholder="What do you need?">
                <button type="submit" id="search">
                  <i class="ti-search"></i>
                </button>
              </div>
            </div>
          </form>
          </div>
        </div>
      </div>
    </div>
            <div class="row">
                <div class="col-lg-12">
                    
                    <div class="cart-table">
                    <a href="/brd/register" class="btn btn-primary mb-3">Register</a>
                        <table>
                            <thead>
                                <tr>
                                    <th>no</th>
                                    <th>title</th>
                                    <th>writer</th>
                                    <th>reg_at</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="bvo" items="${list }"> 
                                <tr>
                                    <td >${bvo.bno }</td>
                                    <td ><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
                                    <td >${bvo.writer }</td>
                                    <td >${bvo.reg_at }</td>
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
<script>
let msg_insert = '<c:out value = "${msg_insert }"/>';
let msg_remove = '<c:out value = "${msg_remove }"/>';
if(msg_insert > 0){
	alert("등록완료");
};
if(msg_remove > 0){
	alert("삭제완료");
};

</script>

<jsp:include page="../footer.jsp"/>