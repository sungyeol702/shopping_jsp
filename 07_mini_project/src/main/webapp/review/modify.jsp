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
                        <span>Review Modify</span>
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
                        <h2>Review Modify</h2>
                        <form action="/rev/update" method="post" enctype="multipart/form-data">
                            <div class="group-input">
                                <label for="pno">pno</label>
                                <input type="text" id="pno" name ="pno" readonly value="${rvo.pno }">
                                <input type="hidden" id="pno" name ="rno" readonly value="${rvo.rno }">
                            </div>
                            <div class="group-input">
                                <label for="title">title</label>
                                <input type="text" id="title" name ="title" value="${rvo.title }">
                            </div>
                            <div class="group-input">
                                <label for="writer">writer</label>
                                <input type="text" id="writer" name ="writer" readonly value=${rvo.writer }>
                            </div>
                            <div class="group-input">
                                <label for="description">Description</label>
                                <textarea rows="" cols="" class="form-control" name="description">${rvo.description }</textarea>
                            </div>
                             <div class="group-input">
                                <label for="image_file">image_file</label>
                                <input type="file" id="image_file" name ="new_file" 
                                 accept="image/png, image/jpeg, image/jpg, image/gif">
                                 
                                <input type="hidden" id="image_file" name ="old_file" 
                                 value="${rvo.image_file }">
                            </div>
                            <button type="submit" class="site-btn register-btn">Update</button>
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