<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../home/top.jsp" />
<link rel="stylesheet" href="${css}/cust/list.css" />
<div class="grid-item" id="navi_bar">
	<jsp:include page="../employee/navi_bar.jsp" />
</div>
<div class="grid-item" id="side_menu">
	<h1>
		<font style="font-size: 30px">고객 목록</font>
	</h1>
</div>
<div class="grid-item" id="content">
	<table id="cust_tab">
		<tr>
			<th>No.</th>
			<th>아이디</th>
			<th>이 름</th>
			<th>생년월일</th>
			<th>성 별</th>
			<th>전화번호</th>
			<th>우편번호</th>
			<th>지번주소</th>
			<th>상세주소</th>
		</tr>

		<!--begin, end, step, varStatus는 생략가능 -->
		<c:forEach items="${list}" var="cus">
			<tr>
				<td>${cus.rnum}</td>
				<td>${cus.customerId}</td>
				<td><a href="${ctx}/customer.do?cmd=cust_retrieve&page=detail&customerId=${cus.customerId}">${cus.customerName}</a></td>
				<td>${cus.ssn}</td>
				<td>남자</td>
				<td>${cus.phone}</td>
				<td>${cus.postalCode}</td>
				<td>${cus.city}</td>
				<td>${cus.address}</td>
			</tr>
		</c:forEach>

	</table>
	<div style="height: 50px"></div>
	<div class="center">
		<div class="pagination">
		
			<!--<<이 표시에 조건을 준다. ㅡ -->
			<c:if test="${pagination.existPrev}"> 
				<a href="${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagination.prevBlock}">&laquo;</a>
			</c:if>

						<!--<<이 부분 수정하자 ㅡ -->
			
			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" varStatus="status">
				<c:choose>
					<c:when test = "${pagination.pageNum eq status.index}">
					
					</c:when>
				    <c:otherwise>
				    
				    </c:otherwise>				
				</c:choose>
				<a href="#" class="page">${status.index}</a>
			</c:forEach>

			<c:if test="${pagination.existNext}">			
			<a href="${ctx}/customer.do?cmd=cust_list&page=list&page_num=${pagination.nextBlock}">&raquo;</a>
			</c:if>
			
		</div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp" />
<script>
	$('.page')
			.click(
					function() {
						location.assign('${ctx}/customer.do?cmd=cust_list&page=list&page_num='
										+ $(this).text());
					});

	/* page_num, pageSize, c
	 * ?cmd=list&page=list&page_num&page_size=5
	 <input type="hidden" name="cmd" value="access" />
	 <input type="hidden" name="page" value="list" />
	 <input type="hidden" name="dir" value="customer" /> */
</script>

