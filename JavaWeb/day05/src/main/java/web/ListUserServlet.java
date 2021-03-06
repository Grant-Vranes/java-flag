package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class ListUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//查询出所有用户的信息
		UserDao dao = new UserDao();
		try {
			List<User> users = dao.findAll();
			//依据查询到的用户信息输出表格
			/*
			 * 因为 Servlet不擅长处理复杂的页面，所以，我们使用
			 * 转发机制，将数据绑订到request对象上，然后转发给
			 * jsp来展现。
			 */
			//step1.将数据绑订到 request对象上
			req.setAttribute("users",users);
			//step2.获得转发器
			RequestDispatcher rd = req.getRequestDispatcher("listUser.jsp");
			//step3.转发
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
	}
	
}
