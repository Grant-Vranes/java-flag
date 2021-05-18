package com.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

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
			String url = request.getUrl();
			//2.2:根据资源路径去webapps目录中寻找该资源
			File file = new File("webapps"+url);
			if(file.exists()) {
				System.out.println("找到该资源");
				//向响应对象中设置要响应的资源内容
				response.setEntity(file);
			}else {
				System.out.println("资源不存在");
			}
			//响应客户端
			response.flush();
			
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
