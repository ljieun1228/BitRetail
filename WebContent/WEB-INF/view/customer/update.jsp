<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/top.jsp" />

<link rel="stylesheet" href="${css}/customer/detail.css" />

<div class="grid-item" id="navi_bar">
	<jsp:include page="../employee/navi_bar.jsp" />
</div>

<div class="grid-item" id="side_bar">
	<div class="myphoto">
		<div class="myphotoin">
			<img src="${img}default_image.jpg "
				style="height: 200px; width: 100%;">
		</div>
	</div>
</div>
<div class="grid-item" id="content">
<form id="form">
	<div class="mypage">
		<div class="mypage1">
			아 이 디 :<br /> 이 름 :<br /> 생년 월일 :<br /> 성 별 :<br /> 전화 번호 :<br />
			주 소 :<br /> 상세 주소 :<br /> 우편 번호 :<br /> 임시비밀번호 :<br />
		</div>
		<div class="mypage2">
			${cus.customerId} <br /> 
			${cus.customerName} <br /> 
			${cus.ssn} <br />
			남 <br /> 
			<input type="text" name="phone" placeholder="${cus.phone}"></input> <br /> 
			<input type="text" name="city" placeholder="${cus.city}"></input> <br /> 
			<input type="text" name="address" placeholder="${cus.address}"></input> <br />
			<input type="text" name="postal_code" placeholder="${cus.postalCode}"></input> <br />
			<input type="text" name="password" placeholder="변경 할 비밀번호"></input> <br />
			
			<input type="hidden" name="id" value="${cus.customerId}"/></input>
			
 			<input type="hidden" name="cmd" value="cust_update"/>
			<input type="hidden" name="page" value="detail"/>	 
			
		</div>
	</div>
		<div class="btn-group" role="group" aria-label="...">
		<button type="button" id="confirm_btn" class="btn btn-default">확 인</button>
		
		<button type="button" id="cancel_btn" class="btn btn-default">취 소</button>
		</div>
</form>
</div>
<script>
$('#confirm_btn').click(()=>{
	var form = $('#form');
	form.attr('action','${ctx}/customer.do');
	form.attr('method','post');
	form.submit();
});

$('#confirm_btn').click(()=>{
	alert('확인!');
	});

</script>
<jsp:include page="../home/bottom.jsp" />
