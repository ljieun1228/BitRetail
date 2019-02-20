<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="top.jsp"/>
<link rel="stylesheet" href="${css}/home/main.css" />
    <div class="grid-item" id="left">
    <br />
    	고객 전용<br /><br />
    	<a href="#" id="cust_join" >회원가입</a><br />
    	<a href="#" id="cust_login" >로 그 인</a>
    <br /> <br />	
    </div>
    <div class="grid-item" id="right">
    <br />
    	직원 전용<br /><br />
    	<a href="#" id="emp_register" >사원등록</a><br />
    	<a href="#" id="emp_access">접속승인</a>
    <br /> <br />	
    	
    </div>
<jsp:include page="bottom.jsp"/>    
<script>
$('#emp_register').click(function(){
    location.assign('employee.do?cmd=move&page=register');
});
$('#emp_access').click(function(){
    location.assign('employee.do?cmd=move&page=access');
});
$('#cust_join').click(function(){
    location.assign('customer.do?cmd=move&page=signup');
});
$('#cust_login').click(function(){
    location.assign('customer.do?cmd=move&page=signin');
});
</script>
 
