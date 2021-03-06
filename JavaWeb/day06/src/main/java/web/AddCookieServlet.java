package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c = new Cookie("username","Sally");
		//设置cookie生存时间
		c.setMaxAge(40);
		resp.addCookie(c);
		
		/*
		 * cookiez只能存放合法的ascii字符，中文要转换成合法的ascii字符的形式。
		 */
		String  city = URLEncoder.encode("北京","utf-8");
		Cookie c2 = new Cookie("city","北京");
		resp.addCookie(c2);
	}
}
