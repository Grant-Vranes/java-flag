package web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.UserDao;
import entity.User;

public class CacheListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 容器启动之后，会立即常见Servlet上下文，就会产生相应的事件，
	 * 容器就会调用此方法
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		//查询t_user表，将所有用户信息查询出来
		UserDao dao = new UserDao();
		try {
			List<User> users = dao.findAll();
			//将用户信息绑定到servlet上下文
			ServletContext sctx = arg0.getServletContext();
			sctx.setAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
