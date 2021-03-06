package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text.html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//读取浏览器发送过来的cookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = URLDecoder.decode(cookie.getValue(),"utf-8");
				out.println(name+":"+value+"<br/>");
			}
		}else {
			out.println("没有Cookie");
		}
	}
}
