package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用来监听session中保存的人数
 * @author Grant·Vranes
 *
 */
public class CountListener implements HttpSessionListener{

	/**
	 * session对象创建之后，容器会调用此方法
	 * 注：HttpSessionEvent是事件对象
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ServletContext sctx = session.getServletContext();
		
		//获取上下文中的在线人数
		Integer count = (Integer)sctx.getAttribute("count");
		if(count == null) {
			//第一个在线用户
			count = 1;
		} else {
			count++;
		}
		sctx.setAttribute("count", count);
	}

	/**
	 * session对象销毁之后，容器会调用此方法
	 * 注：HttpSessionEvent是事件对象
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext sctx = arg0.getSession().getServletContext();
		Integer count = (Integer)sctx.getAttribute("count");
		count--;
		sctx.setAttribute("count", count);
	}

}
