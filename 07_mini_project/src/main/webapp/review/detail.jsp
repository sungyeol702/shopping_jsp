<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<!-- Blog Details Section Begin -->
<section class="blog-details spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="blog-details-inner">
					<div class="blog-detail-title">
						<h2 id = "rno">${rvo.rno} . ${rvo.title }</h2>
						<p>
							reg <span>- ${rvo.reg_at }</span>
						</p>
					</div>
					<c:if test="${rvo.image_file ne null }">
						<div class="blog-large-pic">
							<img src="/_fileUpload/${rvo.image_file }" alt="">
						</div>
					</c:if>
					<p>${rvo.description }</p>
					<div class="tag-share">
						<div class="details-tag">
							<ul>
								<li><i class="fa fa-tags"></i></li>
								<li>product : ${rvo.pname }</li>
								<li id="writer">writer : ${rvo.writer }</li>
								<li>mod_at : ${rvo.mod_at }</li>
							</ul>
						</div>

					</div>
					<c:if test="${ses.id eq rvo.writer}">
						<div class="d-flex justify-content-between mb-3">
							<div class="p-2 ">
								<a id="modalCtaBtn" class="btn btn-primary"
									href="/rev/modify?rno=${rvo.rno }">Modify</a>
							</div>
							<div class="p-2"></div>
							<div class="p-2 ">
						<a id="review" class="btn btn-danger"
									href="/rev/remove?rno=${rvo.rno }&writer=${rvo.writer }">Remove</a>
							</div>
						</div>
					</c:if>

				</div>
			</div>
		</div>
	</div>
</section>
<!-- Blog Details Section End -->
<!-- <script src="/resources/js/review.detail.js"></script> -->

<jsp:include page="../footer.jsp" />