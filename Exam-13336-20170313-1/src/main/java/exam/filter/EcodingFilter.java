package exam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EcodingFilter implements Filter {
	private String Encoding=null;
	public EcodingFilter() {
	}


	public void init(FilterConfig fConfig) throws ServletException {
		Encoding=fConfig.getInitParameter("encoding");
		if(Encoding==null){
			throw new ServletException("EcodingFilter中的编码设置为空！！！");
		}
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(!Encoding.equals(request.getCharacterEncoding())){
			request.setCharacterEncoding(Encoding);
		}
		response.setCharacterEncoding(Encoding);
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
