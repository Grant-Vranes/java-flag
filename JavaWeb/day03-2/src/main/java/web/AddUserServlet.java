package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtils;

public class AddUserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//处理表单中文参数值的问题
		request.setCharacterEncoding("utf-8");
		//读取用户信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//输出用户信息
		/*
		 * 设置content-type消息头的值
		 * out.println方法在输出时，会使用charset指定字符集来编码
		 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//将用户信息插入到数据库
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into t_user values(null,?,?,?)";
			psta = conn.prepareStatement(sql);
			psta.setString(1, username);
			psta.setString(2, password);
			psta.setString(3, email);
			psta.executeUpdate();
//			out.println("<a href='list'>用户列表</a>");
			//重定向到用户列表
			response.sendRedirect("list");
			out.println("添加成功");
		} catch (Exception e) {
			/*
			 * step1:记日志（保留现场）
			 * 注：在实际项目中，经常需要将异常信息写入到文件里面。
			 */
			e.printStackTrace();
			/*
			 * step2:看异常能否恢复，如果异常不能够恢复（比如数据库服务停止、
			 * 		网络中断等等，这样的异常我们一般称之为系统异常），则提示
			 * 		用户稍后重试；
			 * 		如果能够恢复，则立即恢复
			 */
			out.println("系统繁忙，稍后重试");
		} finally {
			DBUtils.close(conn, psta, null);
		}
		
		out.println(username+" "+password+" "+email);
	}
	
}
