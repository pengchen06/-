<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<h3>登录成功</h3>
	<img src="http://pic1.win4000.com/tj/201612/586674976a819.jpg" />
	<input type="text" name="message"
		value="<%=request.getAttribute("message")%>"></input>
	<a href="<%=request.getContextPath() %>/down.jsp"> <input
		type="submit" value="点击下载" ></input></a>
</body>
</html>