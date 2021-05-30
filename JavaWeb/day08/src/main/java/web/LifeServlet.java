package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet{
	public LifeServlet() {
		System.out.println("LifeServlet的构造器");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeServlet的init方法");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeServlet的service方法");
		
		ServletConfig config = getServletConfig();
		//读取初始化参数
		String city = config.getInitParameter("city");
		System.out.println("city:"+city);
	}
}
