<%@page import="exam.entity.FilmEntity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表显示界面</title>
<% 
List<FilmEntity> list=(ArrayList<FilmEntity>)request.getAttribute("list"); %>
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
		<tr>
			<td width="198px" class="tb" align="center">film_id</td>
			<td width="198px" class="tb" align="center">title</td>
			<td width="198px" class="tb" align="center">description</td>
			<td width="198px" class="tb" align="center">language</td>
		</tr>
		<%
		for(int i=0;i<list.size();i++){
		%>
		<tr>
			<td width="198px" class="tb" align="center"><%=list.get(i).getFilm_id()%></td>
			<td width="198px" class="tb" align="center"><%=list.get(i).getTitle()%></td>
			<td width="198px" class="tb" align="center"><%=list.get(i).getDescription() %></td>
			<td width="198px" class="tb" align="center"><%=list.get(i).getEntity().getName() %></td>
			<td width="198px" class="tb" align="center">编辑</td>
			<td width="198px" class="tb" align="center">删除</td>
		</tr>
		<%} %>
	</table>
</body>
</html>