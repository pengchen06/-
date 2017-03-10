package userinfo.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		String imagename= request.getParameter("name");
		// 
		//		InputStream in=DownServlet.class.getClassLoader().getResourceAsStream(imagename);
		//		BufferedInputStream bis=new BufferedInputStream(in);
		//		OutputStream out=new FileOutputStream("image2");
		//		BufferedOutputStream bos=new BufferedOutputStream(out);
		//		byte input[]=new byte[200];
		//		int c=-1;
		//		while((c=bis.read(input))!=-1){
		//			bos.write(input, 0, c);
		//		}
		///*		bos.close();
		//		out.close();
		//		bis.close();
		//		in.close();*/
		//		request.setAttribute("message", "下载成功！！！");
		//		request.getRequestDispatcher("/logined.jsp").forward(request, response);
		String address=request.getParameter("name");
		File file=new File(request.getContextPath()+"/"+address);
		URL url=file.toURL();
		URLConnection uc=url.openConnection();
		uc.connect();
		HttpURLConnection huc=(HttpURLConnection) uc;
		InputStream is=huc.getInputStream();
		BufferedInputStream bis=new BufferedInputStream(is);

		OutputStream out=new FileOutputStream(new File("image"));
		BufferedOutputStream bos=new BufferedOutputStream(out);

		byte input[]=new byte[100];
		int c;
		while((c=bis.read(input))!=-1){
			bos.write(input, 0, c);
		}
		bos.close();
		out.close();
		bis.close();
		is.close();
		request.setAttribute("message", "下载成功！！！");
		request.getRequestDispatcher("/logined.jsp").forward(request, response);
	}

}
