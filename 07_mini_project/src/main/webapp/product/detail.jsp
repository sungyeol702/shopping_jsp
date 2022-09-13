<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<section class="product-shop spad page-details">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
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
			<div class="col-lg-9">
				<div class="row">
					<div class="col-lg-6">
						<div>
							<img class="product-big-img"
								src="/resources/dist/img/products/${pvo.pname }.jpg"
								alt="${pvo.pname }">
						</div>

					</div>
					<div class="col-lg-6">
						<div class="product-details">
							<div class="pd-title">
								<span>${pvo.category }</span>
								<h3>${pvo.pname }</h3>
								<c:if test="${ses.grade == 10 }">
									<a href="/prd/modify?pno=${pvo.pno }" class="btn btn-primary">modify</a>
									<a href="/prd/remove?pno=${pvo.pno }"
										class="btn btn-outline-danger">X </a>
								</c:if>
							</div>
							<div class="pd-rating">
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star-o"></i> <span>(5)</span>
							</div>
							<div class="pd-desc">
								<p>${pvo.description }</p>
								<h4>${pvo.price }</h4>
							</div>

							<div class="pd-size-choose">
								<div class="sc-item">
									<input type="radio" id="sm-size"> <label for="sm-size">free</label>
								</div>

							</div>
							<div class="quantity">
								<div class="pro-qty">
									<input type="text" value="1">
								</div>
								<a href="/prd/buy?pno=${pvo.pno }" class="primary-btn pd-cart">Buy</a>
							</div>
							<ul class="pd-tags">
								<li><span>CATEGORIES</span> ${pvo.category }</li>
								<li><span>REG_AT</span> ${pvo.reg_at }</li>
							</ul>
							<div class="pd-share">
								<div class="p-code" id="pno">Sku : ${pvo.pno }</div>
								<div class="pd-social">
									<a href="#"><i class="ti-facebook"></i></a> <a href="#"><i
										class="ti-twitter-alt"></i></a> <a href="#"><i
										class="ti-linkedin"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="product-tab">
					<div class="tab-item">
						<ul class="nav" role="tablist">
							<li><a class="active" data-toggle="tab" href="#"
								id="descriptionBtn" role="tab">DESCRIPTION</a></li>
							<li><a class="active" data-toggle="tab" href="#" id="reviewBtn"
								role="tab">Customer Reviews</a></li>
						</ul>
					</div>
					<div id ="content">
						<div class="tab-item-content">
							<div class="tab-content">
								<div class="tab-pane fade-in active" id="tab-1" role="tabpanel">
									<div class="product-content">
										<div class="row">
											<div class="col-lg-7">
												<h5>Introduction</h5>
												<p>></p>
											</div>
											<div class="col-lg-5">
												<img src=">resources/dist/img/product-single/tab-desc.jpg"
													alt="">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Product Shop Section End -->
<script>
	let description = '<c:out value="${pvo.description }"/>'
</script>
<script src="/resources/js/product.detail.js"></script>
<script>
spreadDescription();
</script>

<jsp:include page="../footer.jsp" />