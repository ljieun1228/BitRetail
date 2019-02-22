<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/access.css" />

<div class="grid-item" id= "side_bar">
	<h1><font style="font-size: 30px">로그인</font></h1>
</div>

<div class="grid-item" id="content_2">
<form id="form" >
<div id="register-container ">

	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">아이디 </span>
	  <input type="text" id="custId" name="custId" class="form-control" placeholder="아이디를 입력하세요" aria-describedby="basic-addon1" value="test">
	</div><br />
	
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">비밀번호</span>
	  <input type="text" id="custPw" name="custPw"  class="form-control" placeholder="비밀번호를 입력하세요" aria-describedby="basic-addon1" value="password">
	</div><br />	   
	 
	<button type="button" id = "confirm_btn" class="btn btn-default btn-lg">
 		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 확 인 
	</button>
	
	<button type="button" id = "cancel_btn" class="btn btn-default btn-lg">
 		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 취 소
	</button>	
	<input type="hidden" name="cmd" value="signin"/>
	<input type="hidden" name="dir" value="category"/>
	<input type="hidden" name="page" value="main"/>	  
 
	</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(()=>{
	var empno = $('#empno').val();
	var name = $('#name').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});

$('#cancel_btn').click(()=>{
	alert('취소버튼클릭!!');
	});
</script>
