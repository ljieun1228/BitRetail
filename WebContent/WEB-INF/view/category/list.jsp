<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../home/top.jsp" />

<link rel="stylesheet" href="${css}cust/list.css" />

<div class="grid-item" id="navi_bar">
	<jsp:include page="../employee/navi_bar.jsp" />
</div>

<div class="grid-item" id="side_menu" >
	
	<div class="list-group">
		<h2>카테고리</h2>
		<a href="#" class="list-group-item" id="cate_list">목록</a> 
		<a href="#" class="list-group-item" id='cate_register'>등록</a> 
		<a href="#" class="list-group-item" id='cate_sreach'>조회</a> 
		<a href="#" class="list-group-item" id='cate_update'>수정</a>
		<a href="#" class="list-group-item" id='cate_delete'>삭제</a>
	</div>
</div>
<div class="grid-item" id="content" >
	<table id="cust_tab">
		<tr>
			<th>카테고리 ID</th>
			<th>카테고리 명</th>
			<th>카테고리 내용</th>
		</tr>
		
		<c:forEach items="${list}" var="cate">
			<tr>
				<td>${cate.categoryId}</td>
				<td>${cate.categoryName}</td>
				<td><a href="#"></a>${cate.description}</td>
			</tr>
		</c:forEach>

	</table>
	<div style="height: 50px"></div>
<%-- 	<div class="center">
		<div class="pagination">

			<!--<<이 표시에 조건을 준다. ㅡ -->
			<c:if test="${pagination.existPrev}">
				<a
					href="${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagination.prevBlock}">&laquo;</a>
			</c:if>

			<!--<<이 부분 수정하자 ㅡ -->

			<c:forEach begin="${pagination.startPage}"
				end="${pagination.endPage}" varStatus="status">
				<c:choose>
					<c:when test="${pagination.pageNum eq status.index}">

					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>
				<a href="#" class="page">${status.index}</a>
			</c:forEach>

			<c:if test="${pagination.existNext}">
				<a
					href="${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagination.nextBlock}">&raquo;</a>
			</c:if>

		</div>
	</div> --%>
</div>
<jsp:include page="../home/bottom.jsp" />
<script src = "${js}/employee.js"> 
</script>

