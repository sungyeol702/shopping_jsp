<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<!-- Breadcrumb Section Begin -->
<div class="breacrumb-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="breadcrumb-text">
					<a href="#"><i class="fa fa-home"></i> Home</a> <span>modify</span>
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
					<h2>Modify</h2>
					<form action="/prd/update" method="post">
						<div class="group-input">
							<input type="hidden" id="" name="pno" value="${pvo.pno }">
						</div>
						<div class="group-input">
							<label for="pname">PrductNmae</label> <input type="text" id=""
								name="pname" value="${pvo.pname }" required>
						</div>
						<div class="group-input">
							<label for="price">Price</label> <input type="number" id="price"
								name="price" value="${pvo.price }" required>
						</div>
						<div class="group-input">
							<label for="category">Category</label>
							<div class="form-check-inline">
								<label class="form-check-label" for="radio1"> <input
									type="radio" class="form-check-input" id="radio1"
									name="category" value="outer" checked>OUTER
								</label>
							</div>
							<div class="form-check-inline">
								<label class="form-check-label" for="radio1"> <input
									type="radio" class="form-check-input" id="radio1"
									name="category" value="tee" checked>TEE
								</label>
							</div>
							<div class="form-check-inline">
								<label class="form-check-label" for="radio2"> <input
									type="radio" class="form-check-input" id="radio2"
									name="category" value="shirts">SHIRTS
								</label>
							</div>
							<div class="form-check-inline">
								<label class="form-check-label" for="radio2"> <input
									type="radio" class="form-check-input" id="radio2"
									name="category" value="pants">PANTS
								</label>
							</div>
							<div class="form-check-inline">
								<label class="form-check-label" for="radio2"> <input
									type="radio" class="form-check-input" id="radio2"
									name="category" value="shoes/bag">SHOES/BAG
								</label>
							</div>
						</div>
						<div class="group-input">
							<label for="description">Description</label> <input type="text"
								id="" name="description" value="${pvo.description }" required>
						</div>
						<button type="submit" class="site-btn register-btn">Modify</button>
					</form>
					<div class="switch-login"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Register Form Section End -->


<jsp:include page="../footer.jsp" />