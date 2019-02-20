<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "member_detail">
<table>
	<tr>
		<th>구분</th>
		<th>내용</th>
	</tr>
	<tr>
		<td>ID</td>
		<td>${user.id}</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${user.pass}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${user.name}</td>
	</tr>
	<tr>
		<td>주민번호</td>
		<td>${user.ssn}</td>
	</tr>
</table>
</div>