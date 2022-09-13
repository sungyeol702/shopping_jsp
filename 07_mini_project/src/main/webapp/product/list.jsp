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
					<a href="#"><i class="fa fa-home"></i> Home</a> <span>Shop</span>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Breadcrumb Section Begin -->

<!-- Product Shop Section Begin -->
<section class="product-shop spad">
	<div class="container">
		<div class="row">
			<div
				class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
				<div class="filter-widget">
					<h4 class="fw-title">Categories</h4>
					<ul class="filter-catagories">
						<li><a href="/prd/listCate?cate=outer">OUTER</a></li>
            <li><a href="/prd/listCate?cate=tee">TEE</a></li>
            <li><a href="/prd/listCate?cate=shirts">SHIRTS</a></li>
            <li><a href="/prd/listCate?cate=pants">PANTS</a></li>
            <li><a href="/prd/listCate?cate=shoes/bag">SHOES/BAG</a></li>
					</ul>
				</div>
				
				

			</div>
			<div class="col-lg-9 order-1 order-lg-2">
				<div class="product-show-option">
					<div class="row">
						<div class="col-lg-7 col-md-7">
							<a href="/prd/register" class="btn btn-primary mb-3">Register</a>
						</div>

					</div>
				</div>
				<div class="product-list">
					<div class="row">
						<c:forEach var="pvo" items="${list }">
							<div class="col-lg-4 col-sm-6">
								<div class="product-item">
									<div class="pi-pic">
										<a href="/prd/detail?pno=${pvo.pno }"> <img
											src="/resources/dist/img/products/${pvo.pname}.jpg"
											alt="${pvo.pname }">
										</a>
									</div>
									<div class="pi-text">
										<div class="catagory-name">${pvo.category }</div>
										<a href="/prd/detail?pno=${pvo.pno }">
											<h5>${pvo.pname }</h5>
										</a>
										<div class="product-price">${pvo.price }</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
		</div>
	</div>
</section>
<!-- Product Shop Section End -->
<script> 
let msg_insert = '<c:out value = "${msg_insert }"/>';
let msg_remove = '<c:out value = "${msg_remove }"/>';
if(msg_insert > 0){
  alert("상품 등록완료");
};
if(msg_remove > 0){
  alert("상품 삭제완료");
};
</script>
<jsp:include page="../footer.jsp" />