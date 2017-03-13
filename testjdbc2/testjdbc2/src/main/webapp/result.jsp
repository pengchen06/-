<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jdbc.entity.Jdbc_userEntity"%>
<%@page import="java.util.List"%>
<%@page import="jdbc.entity.Jdbc_addresEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Jdbc_addresEntity entity=(Jdbc_addresEntity)request.getAttribute("addres");
List<Jdbc_userEntity> list=(ArrayList<Jdbc_userEntity>)request.getAttribute("user");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
<style type="text/css">
.tb {
	border-width: 1px;
	border-collapse: collapse;
	border-color: Yellow;
	border-style: solid;
}
</style>
</head>
<body>
	<table width="600px" height="50px" border="1px" cellpadding="0"
		cellspacing="0" class="tb">
		<tr align="center">
			<td colspan="3">居住在<%=entity.getAddress_id() %>的人有
			</td>
		</tr>
		<tr>
			<td width="198px" class="tb" align="center">居住位置名字</td>
			<td width="198px" class="tb" align="center">姓名</td>
			<td width="198px" class="tb" align="center">爱好</td>
		</tr>
		<%
		Iterator<Jdbc_userEntity> it=list.iterator();
		while(it.hasNext()){
		Jdbc_userEntity u_entity=(Jdbc_userEntity)it.next();%>
		<tr>
			<td width="198px" class="tb" align="center"><%=entity.getAddress_name() %></td>
			<td width="198px" class="tb" align="center"><%=u_entity.getName()%></td>
			<td width="198px" class="tb" align="center"><%=u_entity.getHobby() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>