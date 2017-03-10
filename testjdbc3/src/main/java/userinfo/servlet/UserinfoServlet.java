package userinfo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userinfo.services.userinfoServices;

public class UserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserinfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		userinfoServices service=new userinfoServices();
		boolean b=false;
		RequestDispatcher rd=null;
		
		if("".equals(username)){
			request.setAttribute("message", "用户名不能为空，请重新输入！！！");
			rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		if("".equals(userpass)){
			request.setAttribute("message", "密码不能为空，请重新输入！！！");
			rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		b=service.select(username, userpass);
		System.out.println(b);
		if(b){
			rd=request.getRequestDispatcher("logined.jsp");
			rd.forward(request, response);
			
		   
		}else{
			request.setAttribute("message", "该用户不存在！！！");
			rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
	}

}
