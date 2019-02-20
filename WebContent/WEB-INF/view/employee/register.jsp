<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/register.css" />
<div class="grid-item" id="content_1">
 	<h1>사원 등록</h1>
</div>
<div class="grid-item" id="content_2">
<form id="form" name="form" >
	<div id="register-container">
	
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">프로필 </span>
		  <input type="text" id="photo" name="photo" class="form-control" placeholder="사진" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">이름 </span>
		  <input type="text" id="name" name="name" class="form-control" placeholder="이름" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">직급 </span>
		  <input type="text" id="manager" name="manager" class="form-control" placeholder="MANAGER" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">생년월일 </span>
		  <input type="text" id="birth_date" name="birth_date" class="form-control" placeholder="생년월일" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">비고</span>
		  <input type="text" id="desc" name="desc" class="form-control" placeholder="비고" aria-describedby="basic-addon1">
		</div><br />
			
		<button type="button" id = "confirm_btn" class="btn btn-default btn-lg">
	 		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 확 인 
		</button>
		
		<button type="button" id = "cancel_btn" class="btn btn-default btn-lg">
	 		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 취 소
		</button>	
				
	    <input type="hidden" name="cmd" value="register" />
	    <input type="hidden" name="page" value="access" />
	
	</div>
</form>
	    <!-- <div class="grid-item" id="reg_item_1">프로필사진</div>
	    <div class="grid-item" id="reg_item_2"><input type="text" id="photo" name="photo" ></div>
	    <div class="grid-item" id="reg_item_3">이 름</div>
	    <div class="grid-item" id="reg_item_4"><input type="text" id="name" name="name" ></div>
	    <div class="grid-item" id="reg_item_5">매니저</div>
	    <div class="grid-item" id="reg_item_6"><input type="text" id="manager" name="manager" ></div>
	    <div class="grid-item" id="reg_item_7">생년월일</div>
	    <div class="grid-item" id="reg_item_8"><input type="text" id="birth_date" name="birth_date" ></div>
	    <div class="grid-item" id="reg_item_9">상 세</div>
	    <div class="grid-item" id="reg_item_10"><input type="text" id="desc" name="desc" ></div>
	    <div class="grid-item" id="reg_item_11"><input type="submit" id="confirm_btn" value='확 인'></div>
	    <div class="grid-item" id="reg_item_12"><input type="reset" id="cancel_btn" value='취 소'> </div>
	     -->
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var empno = $('#empno').val();
	var name = $('#name').val();
	var manager = $('#manager').val();
	var birthday = $('#birthday').val();
	var desc = $('#desc').val();
	$('#form')
	.attr('action', '${ctx}/employee.do')
	.submit();
});
$('#cancel_btn').click(function(){
	alert('취소');
	});
</script>




