<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../header.jsp" />
<!-- Faq Section Begin -->
<div class="faq-section spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="faq-accordin">
					<div class="accordion" id="accordionExample">
						<div class="card">
							<div class="card-heading active"></div>
							<c:if test="${empty code }">
								<p>찾으시는정보가없습니다.</p>
								<a href="/mem/find_pwd"> 비밀번호 다시찾기</a>
							</c:if>
							<c:if test="${not empty code}">
								<p>찾는정보 : ${code }</p>
								<a href="/mem/login"> 로그인</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Faq Section End -->


<jsp:include page="../footer.jsp" />