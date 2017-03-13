package jdbc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.entity.Jdbc_addresEntity;
import jdbc.entity.Jdbc_userEntity;
import jdbc.services.Jdbc_addresService;
import jdbc.services.Jdbc_userService;

public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SelectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("address_id").toString();
		RequestDispatcher rd=null;
		if("".equals(id)){
			request.setAttribute("message", "请输入address_id！！！");
			rd=request.getRequestDispatcher("/select.jsp");
			rd.forward(request, response);
		}else{
			int address_id=Integer.parseInt(id);
			Jdbc_userService   u_service=new Jdbc_userService();
			Jdbc_addresService a_service=new Jdbc_addresService();
			List<Jdbc_userEntity>   u_list=null;
			Jdbc_addresEntity entity=null;

			u_list=u_service.select(address_id);
			entity=a_service.select(address_id);

			if(u_list!=null && entity.getAddress_id()!=0){
				request.setAttribute("user", u_list);
				request.setAttribute("addres", entity);
				rd=request.getRequestDispatcher("/result.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "该ID不存在");
				rd=request.getRequestDispatcher("/select.jsp");
				rd.forward(request, response);
			}
		}
	}
}
