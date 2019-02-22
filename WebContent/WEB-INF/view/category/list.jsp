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
<script>
	$('.page').click(()=> {
		location.assign('${ctx}/customer.do?cmd=cust_list&page=list&page_num='+ $(this).text());
		});
	
	$('#cate_list').click(()=>{
		location.assign('${ctx}/category.do?cmd=cate_list&page=list');
		});
	
	$('#cate_register').click(()=>{
		$('#content').html(
				'<form id="form">'
				+'  <div class="form-group">'
				+'    <label for="text">[카테고리 이름]</label>'
				+'    <input type="text" class="form-control" name="cate_name">'
				+'  </div>'
				+'  <div class="form-group">'
				+'    <label for="text">[상세 설명]</label>'
				+'    <textarea rows="4" cols="30" type="text" class="form-control" name="description"></textarea>'
				+'  </div>'
				+'  <button type="submit" class="btn btn-default">등록</button>'
				+'</form>');
	});
	
	$('#cate_sreach').click(()=>{
		$('#content').html(	'<div class="btn-group">'
				+'<button class="btn btn-default btn-lg dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">'
				+'카테고리<span class="caret"></span>'
				+'</button>'
				+'<ul class="dropdown-menu" role="menu">'
				+'스마트폰'
				+'갤럭시'
				+'삼성'
				+'</ul>'
				+'</div>');
	});
	
	$('#cate_delete').click(()=>{
		$('#content').html(
				'<input type="radio" name="vehicle1" value="Bike"> 스마트폰<br>'
				+'<input type="radio" name="vehicle2" value="Car"> 데스크탑<br>'
				+'<input type="radio" name="vehicle3" value="Boat" checked> 노트북<br>'
		);
	});
	
	$('#cate_update').click(()=>{
		$('#content').html(
				'<div class="container">'
				+'  <h2>수정사항</h2>'
				+'	<form id="form">'
				+'			<input type="radio" name="vehicle1" value="Bike"> 스마트폰<br>'
				+'			<input type="radio" name="vehicle2" value="Car"> 데스크탑<br>'
				+'			<input type="radio" name="vehicle3" value="Boat" checked> 노트북<br>'
				
				+'  <!-- Trigger the modal with a button -->'
				+'  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button>'
				+'  <!-- Modal -->'
				+'  <div class="modal fade" id="myModal" role="dialog">'
				+'    <div class="modal-dialog">'
				+'      <!-- Modal content-->'
				+'      <div class="modal-content">'
				+'        <div class="modal-header">'
				+'          <button type="button" class="close" data-dismiss="modal">&times;</button>'
				
				+'          <h4 class="modal-title">카테고리 수정</h4>'
				+'        </div>'
				+'        <div class="modal-body">'
	   					
				
				+'  <div class="form-group">'
				+'    <label for="text">[카테고리 이름]</label>'
				+'    <input type="text" class="form-control" name="cate_name">'
				+'  </div>'
				+'  <div class="form-group">'
				+'    <label for="text">[상세 설명]</label>'
				+'    <textarea rows="4" cols="30" type="text" class="form-control" name="description"></textarea>'
				+'  </div>'
				+'  <button type="submit" class="btn btn-default">등록</button>'
				
				
				+'        </div>'
				+'        <div class="modal-footer">'
				+'          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'
				+'        </div>'
				+'      </div>'
				+'    </div>'
				+'  </div>'
				+' </form>
				+'</div>'
		);
	});
	
</script>

