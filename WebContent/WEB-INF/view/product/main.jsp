<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../home/top.jsp"%>
<body>
	<table id="wrapper">
		<tr>
			<td colspan="2"><%@include file="../home/top.jsp"%>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			</td>
		</tr>
		<tr style="height: 300px">
			<td style="width: 30%"><%@include file="side-menu.jsp"%>
			</td>
			<td>
			<%
			String dest = String.valueOf(request.getAttribute("dest"));
			System.out.print("dest: "+ dest);
			switch(dest){
			case "NONE" :
				%>
				<%@include file="account-page.jsp"%>
				<%
			break;
			case "open-form":
				%>
				<%@include file="open-form.jsp"%>
				<%
			break;
			case "open-result":

			break;
			}
			%>
			</td>
		</tr>
		<tr style="height: 100px">
			<td colspan="2"><%@ include file="../home/bottom.jsp"%>
			</td>
		</tr>
	</table>
</body>
</html>







