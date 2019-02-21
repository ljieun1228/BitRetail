<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/signup.css" />
<div class="grid-item" id="content_1">
 	<h1>회원가입</h1>
</div>
 <div class="grid-item" id="content_2">
<form id="form" >
<div id="register-container">
  <div class="input-group">
  <span class="input-group-addon" id="basic-addon1">아이디</span>
  <input type="text" class="form-control"  placeholder="아이디를 입력해주세요." aria-describedby="basic-addon1" id="cusId" name="cusId">
</div>  
<div class="input-group">
  <span class="input-group-addon" id="basic-addon2">비밀번호</span>
  <input type="text" class="form-control"  placeholder="비밀번호를 입력해주세요." aria-describedby="basic-addon2" id="cusPw" name="cusPw">
  </div>
 <div class="input-group"> 
  <span class="input-group-addon" id="basic-addon3">이름</span>
  <input type="text" class="form-control"  placeholder="이름을 입력해주세요." aria-describedby="basic-addon3" id="contactName" name="contactName">
  </div>
 <div class="input-group"> 
  <span class="input-group-addon" id="basic-addon4">주민번호</span>
  <input type="text" class="form-control" placeholder="주민번호를 입력해주세요." aria-describedby="basic-addon4"  id="ssn" name="ssn">	
  </div>
 <div class="input-group"> 
  <span class="input-group-addon" id="basic-addon5">시 명칭</span>
  <input type="text" class="form-control"  placeholder="시를 입력해주세요.(서울시)" aria-describedby="basic-addon5" id="city" name="city">
  	</div>
  <div class="input-group">
  <span class="input-group-addon" id="basic-addon6">상세주소</span>
  <input type="text" class="form-control"  placeholder="상세주소를 입력해주세요." aria-describedby="basic-addon6" id="address" name="address">	
  	</div>
  <div class="input-group">
  <span class="input-group-addon" id="basic-addon7">우편번호</span>
  <input type="text" class="form-control" placeholder="우편번호를 입력해주세요." aria-describedby="basic-addon7" id="pCode"  name="pCode">
  </div>
    <div class="input-group">
  <span class="input-group-addon" id="basic-addon8">핸드폰번호</span>
  <input type="text" class="form-control" placeholder="핸드폰번호를 입력해주세요." aria-describedby="basic-addon8" id="phone"  name="phone">
  </div>
    <div class="input-group">
  <span class="input-group-addon" id="basic-addon9">성별</span>
  <input type="text" class="form-control" placeholder="성별을 입력해주세요." aria-describedby="basic-addon9" id="gender"  name="gender">
  </div>
    <div class="input-group">

  <button type="button" id = "confirm_btn" class="btn btn-default btn-lg">
 		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 확 인 
  </button>
  <button type="button" id = "cancel_btn" class="btn btn-default btn-lg">
 		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 취 소
  </button>
  <input type="hidden" name="cmd" value="signup" />
  <input type="hidden" name="page" value="signin" />
  </div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var cusId = $('#cusId').val();
	var cusName = $('#cusName').val();
	var contactName = $('#contactName').val();
	var address = $('#address').val();
	var city = $('#city').val();
	var postalCode = $('#postalCode').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
$('#cancel_btn').click(function(){
	alert('취소버튼클릭!!');
	});
</script>




