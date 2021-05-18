package com.webserver.core;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.servlets.HttpServlet;
import com.webserver.servlets.LoginServlet;
import com.webserver.servlets.RegServlet;
import com.webserver.servlets.UpdateServlet;

/**
 * 	客户端处理类
 * 	处理客户端请求
 * @author Grant·Vranes
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	 
	public ClientHandler(Socket socket) {//有参构造
		this.socket = socket;
	}
	public void run() {
		/*
		 * 	当浏览器连接上我们服务器，就会给我们发送一个标准
		 * 	的http请求内容过来，那么下面就看看客户端浏览器发了什么
		 */
		try {
			/*
			 * 	主流程：
			 * 	1：解析请求
			 * 	2：处理请求
			 * 	3：发送响应
			 */
			//1:准备工作
			//1.1解析请求，创建请求对象
			HttpRequest request = new HttpRequest(socket);
			//1.2创建响应对象
			HttpResponse response = new HttpResponse(socket);
			
			//2:处理请求
			//2.1：获取请求的资源路径
			String url = request.getRequestURI();
			//System.out.println("============="+url);
			
			//判断该请求是否为请求业务
			String servletName = ServerContent.getServletName(url);
			if(servletName != null) {
				//使用映射解决
				System.out.println("映射：" + servletName);
				Class cls = Class.forName(servletName);
				HttpServlet servlet = (HttpServlet)cls.newInstance();
				servlet.service(request, response);
			} else {
				//2.2:根据资源路径去webapps目录中寻找该资源
				File file = new File("webapps"+url);
				if(file.exists()) {
					System.out.println("找到该资源");
					//向响应对象中设置要响应的资源内容
					response.setEntity(file);
				}else {
					//设置状态代码404
					response.setStatusCode(404);
					//设置404页面
					response.setEntity(new File("webapps/root/404.html"));
					System.out.println("资源不存在");
				}
			}
			
			//3:响应客户端
			response.flush();
			
		} catch(EmptyRequestException e) {
			/*
			 * 	实例化HttpRequest时若发现是空请求时，该构造方法会将该异常抛出，
			 * 	这里不做任何处理，直接再finally中与客户端断开即可，这样就不会
			 * 	出现数组下标越界
			 */
			System.out.println("空请求");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//与客户端断开链接
			try {
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
