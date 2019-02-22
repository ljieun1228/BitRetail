<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/top.jsp" />

<link rel="stylesheet" href="${css}/customer/detail.css" />

 <div class="grid-item" id="navi_bar">
	<jsp:include page="../employee/navi_bar.jsp" />
</div>

<div class="grid-item" id="side_bar">
			<br />
		    <form id="form" >   
			<img src="${img}${image.imgName}.${image.imgExtention}"
				 style="height: 200px; width: 200px;"> 
			<input type="file"	name='file_upload' /> 
			<input type="submit" id="file_upload_btn" />
		</form>
	</div>

<div class="grid-item" id="content">
	<div class="mypage">
			<table>
				<tr>
					<td>아이디</td>
					<td>${cus.customerId}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${cus.customerName}</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>${cus.ssn}</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>남</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>${cus.phone}</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${cus.city}</td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td>${cus.address}</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>${cus.postalCode}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${cus.customerPw}</td>
				</tr>
			</table>
			<br />
		</div>
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" id="update_btn" class="btn btn-default">수정</button>
			</div>
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" id="delete_btn" class="btn btn-default">회원 탈퇴</button>
			</div>
	</div>

<script>
	$('#update_btn').click(()=> {
		location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerId=${cus.customerId}');
			});
	
	$('#delete_btn').click(()=> {
		alert('회원 탈퇴 되었습니다.');
		location.assign('${ctx}/customer.do?cmd=cust_delete&page=main&customerId=${cus.customerId}');
			});
	
	$('#file_upload_btn').click(()=> {
		alert('사진업로드 버튼 클릭!');
				$('#form')
				.attr('method', 'post')
				.attr('action',	'${ctx}/customer.do?cmd=cust_file_upload&page=detail&customer_id=${cus.customerId}')
				.attr('enctype', 'multipart/form-data')
				.submit();
			})
</script>

<jsp:include page="../home/bottom.jsp" />
