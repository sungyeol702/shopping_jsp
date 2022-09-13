<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Register</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Form Section Begin -->

    <!-- Register Section Begin -->
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="register-form">
                        <h2>Register</h2>
                        <form action="/mem/update" method="post">
                            <div class="group-input">
                                <label for="id">UserID</label>
                                <input type="text" readonly value=${mvo.id } name ="id">
                            </div>
                            <div class="group-input">
                                <label for="pwd">Password *</label>
                                <input type="password"value=${mvo.pwd } id="pass" name ="pwd" required>
                            </div>
                            <div class="group-input">
                                <label for="name">UserName *</label>
                                <input type="text" id="" value=${mvo.name } name="name" required>
                            </div>
                            <div class="group-input">
                                <label for="address">UserAddress *</label>
                                <input type="text" id="" name="address" value=${mvo.address }>
                            </div>
                            <div class="group-input">
                                <label for="address">UserGrade *</label>
                                <input type="text" id="" name="grade" value=${mvo.grade }>
                            </div>
                            <button type="submit" class="site-btn register-btn">update</button>
                        </form>
                        <div class="switch-login">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Register Form Section End -->


<jsp:include page="../footer.jsp"/>