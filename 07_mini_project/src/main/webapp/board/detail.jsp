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
						<h2 id="bno">${bvo.bno }.${bvo.title }</h2>
						<p>
							reg <span>-${bvo.reg_at }</span>
						</p>
					</div>
					<div class="blog-quote">
						<p>${bvo.description }</p>
					</div>
					<div class="tag-share">
						<div class="details-tag">
							<ul>
								<li>writer : ${bvo.writer }</li>
								<li>mod_at : ${bvo.mod_at }</li>
							</ul>
						</div>
					</div>
					<c:if test="${ses.name eq bvo.writer}">
						<div class="d-flex justify-content-between mb-3">
							<div class="p-2 ">
								<a id="modalCtaBtn" class="btn btn-primary"
									href="/brd/modify?bno=${bvo.bno }">Modify</a>
							</div>
							<div class="p-2"></div>
							<div class="p-2 ">
								<a id="modalCtaBtn" class="btn btn-danger"
									href="/brd/remove?bno=${bvo.bno }">Remove</a>
							</div>
						</div>
					</c:if>
					<div id="commentBox">
						<div class="posted-by row">
							<div class="col-sm-2">name</div>
							<div class="pb-text col-sm-7">
								comment text
							</div>
							<div class="pb-text col-sm-2">
								reg_at
							</div>
							<div class="pb-text col-sm-1">
								<button class="btn btn-danger" id="cmtdal">x</button>
							</div>
						</div>
						
					</div>

					<div class="leave-comment">
						<h4>Comment</h4>
						<form action="#" class="comment-form">
							<div class="row">
								<div class="col-lg-6">
									<input type="text" readonly id="writer" value=${ses.id }>
								</div>
								<div class="col-lg-12">
									<input type="text" placeholder="Messages" id="cmtText"></input>
									<button type="button" class="site-btn" id="cmtPostBtn">Send
										message</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Blog Details Section End -->

<script src="/resources/js/board.detail.js"></script>
<script>
	printCommentList();
</script>
<jsp:include page="../footer.jsp" />