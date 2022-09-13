<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Fashi | Template</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="/resources/dist/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/themify-icons.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="/resources/dist/css/style.css"
	type="text/css">
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<header class="header-section">
		<div class="header-top">
			<div class="container">
				<div class="ht-left">
					<div class="mail-service">
						<i class=" fa fa-envelope"></i> hello.colorlib@gmail.com
					</div>
					<div class="phone-service">
						<i class=" fa fa-phone"></i> +65 11.188.888
					</div>
				</div>
				<div class="ht-right">
					<c:if test="${ses ne null }">
						<a href="/mem/detail?em=${ses.id }" class="login-panel" id="sesid"><i
							class="fa fa-user"></i>${ses.id }</a>
					</c:if>
					<c:if test="${ses eq null }">
						<a href="/mem/login" class="login-panel"><i class="fa fa-user"></i>login</a>
					</c:if>
					<div class="lan-selector">
						<select class="language_drop" name="countries" id="countries"
							style="width: 300px;">
							<option value='yt' data-image="/resources/dist/img/flag-1.jpg"
								data-imagecss="flag yt" data-title="English">English</option>
							<option value='yu' data-image="/resources/dist/img/flag-2.jpg"
								data-imagecss="flag yu" data-title="Bangladesh">German
							</option>
						</select>
					</div>
					<div class="top-social">
						<a href="#"><i class="ti-facebook"></i></a> <a href="#"><i
							class="ti-twitter-alt"></i></a> <a href="#"><i
							class="ti-linkedin"></i></a> <a href="#"><i class="ti-pinterest"></i></a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="nav-item">
			<div class="container">
				<div class="nav-depart">
					<div class="depart-btn">
						<i class="ti-menu"></i> <span>All departments</span>
						<ul class="depart-hover">
							<li class="active"><a href="/prd/listCate?cate=outer">OUTER</a></li>
							<li><a href="/prd/listCate?cate=tee">TEE</a></li>
							<li><a href="/prd/listCate?cate=shirts">SHIRTS</a></li>
							<li><a href="/prd/listCate?cate=pants">PANTS</a></li>
							<li><a href="/prd/listCate?cate=shoes/bag">SHOES/BAG</a></li>
							<!--  <li><a href="#">Accessories/Shoes</a></li>
                            <li><a href="#">Luxury Brands</a></li>
                            <li><a href="#">Brand Outdoor Apparel</a></li> -->
						</ul>
					</div>
				</div>
				<nav class="nav-menu mobile-menu">
					<ul>
						<li class="active"><a href="/">Home</a></li>
						<li><a href="/prd/listAll">Shop</a></li>
						
						<li><a href="/brd/list">Board</a></li>
						<c:if test="${ses.grade == 10 }">
							<li><a href="/mem/list">UserList</a></li>
						</c:if>
						<li><a href="#">Pages</a>
							<ul class="dropdown">
								<c:if test="${ses ne null }">
									<c:if test="${ses.grade eq 10 }">
										<li><a href="/buy/listAll">Buy List</a></li>
									</c:if>
									<c:if test="${ses.grade ne 10 }">
									<li><a href="/buy/list?em=${ses.id }">Buy List</a></li>
									</c:if>
									<li><a href="/rev/mlist?em=${ses.id }">My Review</a></li>
									<li><a href="/">Faq</a></li>
									<li><a href="/mem/logout">logout</a></li>
								</c:if>
								<c:if test="${ses eq null }">
									<li><a href="/mem/join">Join</a></li>
									<li><a href="/mem/login">Login</a></li>
								</c:if>
							</ul></li>
					</ul>
				</nav>
				<div id="mobile-menu-wrap"></div>
			</div>
		</div>
	</header>
	<!-- Header End -->