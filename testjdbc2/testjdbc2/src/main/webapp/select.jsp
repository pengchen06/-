<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询页面</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/SelectServlet" method="post">
 <input type="text" id="address_id" name="address_id"></input>
 <input type="submit" value="查询"></input>
 <input type="text" id="message" name="message" value="<%=request.getAttribute("message") %>" border="0px"></input>
</form>
</body>
</html>