package exam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.entity.FilmEntity;
import exam.services.LoginService;

public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService servies=new LoginService();
		List<FilmEntity> list=new ArrayList<FilmEntity>();
		RequestDispatcher rd=null;

		list=servies.select();
		if(list!=null){
			request.setAttribute("list", list);
			request.setAttribute("message", "查询成功！！！");
			rd=request.getRequestDispatcher("logined/film.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("message", "查询失败");
			rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
