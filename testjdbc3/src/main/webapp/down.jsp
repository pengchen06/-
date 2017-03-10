<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
URL url=new URL("http://pic1.win4000.com/tj/201612/586674976a819.jpg");
URLConnection uc=url.openConnection();
uc.connect();
HttpURLConnection huc=(HttpURLConnection) uc;
InputStream is=huc.getInputStream();
BufferedInputStream bis=new BufferedInputStream(is);

OutputStream os=new FileOutputStream("D:/image.jpg");
BufferedOutputStream bos=new BufferedOutputStream(os);

byte input[]=new byte[100];
int c;
while((c=bis.read(input))!=-1){
	bos.write(input, 0, c);
}
bos.close();
os.close();
bis.close();
is.close();
request.setAttribute("message", "下载成功！！！");
request.getRequestDispatcher("/logined.jsp").forward(request, response);
%>