<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/employee/navi_bar.css" />

<nav class="navbar navbar-default">
	<div class="container-fluid" id="navi_bar">
		<ul class="nav navbar-nav">
			<li><a href="home.do">홈</a></li>
			<li><a href="${ctx}/category.do?cmd=cate_list&page=list">카테고리</a></li>
			<li><a href="${ctx}/customer.do?cmd=cust_list&page=list">고객</a></li>
			<li><a href="#">사원</a></li>
			<li><a href="#">주문</a></li>
			<li><a href="${ctx}/product.do?cmd=product_list&page=list">상품</a></li>
			<li><a href="#">선박</a></li>
			<li><a href="#">공급업체</a></li>
		</ul>
	</div>
</nav>
