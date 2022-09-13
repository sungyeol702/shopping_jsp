<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<section class="contact-section spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-5">
				<div class="contact-title">
					<h4>Contacts Us</h4>
					<p>Contrary to popular belief, Lorem Ipsum is simply random
						text. It has roots in a piece of classical Latin literature from
						45 BC, maki years old.</p>
				</div>
				<div class="contact-widget">
					<div class="cw-item">
						<div class="ci-icon">
							<i class="ti-location-pin"></i>
						</div>
						<div class="ci-text">
							<span>id:</span>
							<p>${mvo.id }</p>
						</div>
					</div>
					<div class="cw-item">
						<div class="ci-icon">
							<i class="ti-location-pin"></i>
						</div>
						<div class="ci-text">
							<span>name:</span>
							<p>${mvo.name }</p>
						</div>
					</div>
					<div class="cw-item">
						<div class="ci-icon">
							<i class="ti-location-pin"></i>
						</div>
						<div class="ci-text">
							<span>address:</span>
							<p>${mvo.address }</p>
						</div>
					</div>
					<div class="cw-item">
						<div class="ci-icon">
							<i class="ti-location-pin"></i>
						</div>
						<div class="ci-text">
							<span>total_amount:</span>
							<p>${mvo.total_amount }</p>
						</div>
					</div>
					<div class="cw-item">
						<div class="ci-icon">
							<i class="ti-location-pin"></i>
						</div>
						<div class="ci-text">
							<span>grade:</span>
							<p>${mvo.grade }</p>
						</div>
					</div>
					<div class="cw-item">
						<div class="ci-icon">
							<i class="ti-location-pin"></i>
						</div>
						<div class="ci-text">
							<span>reg_at:</span>
							<p>${mvo.reg_at }</p>
						</div>
					</div>
					<div class="cw-item">
						<div class="ci-icon">
							<i class="ti-location-pin"></i>
						</div>
						<div class="ci-text">
							<span>last_login:</span>
							<p>${mvo.last_login }</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${ses.id == mvo.id}">
	<a href="/mem/modify?em=${mvo.id }" class="site-btn login-btn">modify</a>
	<a id="modalCtaBtn" class="btn btn-danger" href="/mem/remove?em=${bvo.bno }">Remove</a>
	</c:if>
	</div>
</section>

<jsp:include page="../footer.jsp" />