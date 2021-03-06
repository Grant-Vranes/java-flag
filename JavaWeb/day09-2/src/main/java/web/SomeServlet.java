package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SomeServlet
 */
public class SomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的路径
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		//为了比较方便，截取请求资源路径的一部分
		String path = uri.substring(uri.lastIndexOf('/'), uri.lastIndexOf('.'));
		System.out.println("path:"+path);
		if("login".equals(path)) {
			System.out.println("处理登录请求...");
		}else if("list".equals(path)) {
			System.out.println("处理用户列表请求...");
		}
	}
}
