<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp"/>
<!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>ReviewRegister</span>
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
                        <h2>Review Register</h2>
                        <form action="/rev/insert" method="post" enctype="multipart/form-data">
                            <div class="group-input">
                                <label for="pno">pno</label>
                                <input type="text" id="pno" name ="pno" readonly value="${pno }">
                            </div>
                            <div class="group-input">
                                <label for="title">title</label>
                                <input type="text" id="title" name ="title" required>
                            </div>
                            <div class="group-input">
                                <label for="writer">writer</label>
                                <input type="text" id="writer" name ="writer" readonly value=${ses.id }>
                            </div>
                            <div class="group-input">
                                <label for="description">Description</label>
                                <textarea rows="" cols="" class="form-control" name="description" required></textarea>
                            </div>
                             <div class="group-input">
                                <label for="image_file">image_file</label>
                                <input type="file" id="image_file" name ="image_file" 
                                 accept="image/png, image/jpeg, image/jpg, image/gif">
                            </div>
                            <button type="submit" class="site-btn register-btn">REGISTER</button>
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