package exam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.services.LoginService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService service=new LoginService();


	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		boolean b=false;
		RequestDispatcher rd=null;
		b=service.select(username);
		if(b){
			response.sendRedirect(request.getContextPath()+"/FilmServlet");
		}else{
			request.setAttribute("message", "登录失败");
			rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}
