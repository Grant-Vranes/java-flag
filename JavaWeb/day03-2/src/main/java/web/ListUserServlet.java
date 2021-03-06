package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
			out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
			out.println("<tr><td>ID</td> <td>用户名</td> <td>密码</td> <td>邮箱</td> <td>操作</td></tr>");
			for (User user : users) {
				int id = user.getId();
				String username = user.getUsername();
				String password = user.getPassword();
				String email = user.getEmail();
				out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+password+"</td><td>"+email+"<td><a href='del?id="+id+"'>删除</a></tr>");
			}	
			out.println("</table>");
			out.println("<a href='addUser.html'>添加用户</a>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
	}
	
}
