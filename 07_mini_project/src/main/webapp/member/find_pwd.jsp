<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
                        <h2>find_pwd</h2>
                        <form action="/mem/findpw" method="post">
                            <div class="group-input">
                                <label for="id">UserID *</label>
                                <input type="text" id="id" name="id" required>
                            </div>
                            <div class="group-input">
                                <label for="text">UserName *</label>
                                <input type="text" id="pass" name="name" required>
                            </div>
                          
                            <button type="submit" class="site-btn login-btn">find</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


<jsp:include page="../footer.jsp"/>