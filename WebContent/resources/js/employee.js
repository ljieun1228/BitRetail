var context = "${ctx}";
$('.page').click(()=> {
	location.assign(ctx 
			+ '/customer.do?cmd=cust_list&page=list&page_num='+ $(this).text());
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
			+' </form>'
			+'</div>'
	);
});
	