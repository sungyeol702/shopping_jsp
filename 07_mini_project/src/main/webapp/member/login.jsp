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
                        <span>Login</span>
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
                    <div class="login-form">
                        <h2>Login</h2>
                        <form action="/mem/login_auth" method="post">
                            <div class="group-input">
                                <label for="id">UserID *</label>
                                <input type="text" id="id" name="id" required>
                            </div>
                            <div class="group-input">
                                <label for="pass">Password *</label>
                                <input type="password" id="pass" name="pwd" required>
                            </div>
                            <div class="group-input gi-check">
                                <div class="gi-more">
                                   
                                    <a href="/mem/find_id" class="forget-pass">Forget your Id</a><br>
                                    <a href="/mem/find_pwd" class="forget-pass">Forget your Password</a>
                                </div>
                            </div>
                            <button type="submit" class="site-btn login-btn">Sign In</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Register Form Section End -->
 <script>
let msg_login = '<c:out value="${msg_login}"/>';
if (msg_login >0) {
  alert("아이디 또는  비밀번호가 틀렸습니");
};

</script>
<jsp:include page="../footer.jsp"/>