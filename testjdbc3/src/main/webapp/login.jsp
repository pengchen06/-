<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/UserinfoServlet"
		method="post">
		username:<input type="text" id="username" name="username"></input><br />
		userpass:<input type="password" id="userpass" name="userpass"></input><br />
		<input type="submit" value="登录"></input><input type="reset" value="重置"></input><br />
		<input type="text" id="message" name="message"
			value="<%=request.getAttribute("message")%>"></input>
	</form>
</body>
</html>