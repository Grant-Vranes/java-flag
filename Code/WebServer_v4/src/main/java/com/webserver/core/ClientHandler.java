package com.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.webserver.http.HttpRequest;

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
			//1:解析请求
			HttpRequest request = new HttpRequest(socket);
			
			//2:处理请求
			//2.1：获取请求的资源路径
			String url = request.getUrl();
			//2.2:根据资源路径去webapps目录中寻找该资源
			File file = new File("webapps"+url);
			if(file.exists()) {
				System.out.println("找到该资源");
				//响应客户端该资源
				OutputStream out = socket.getOutputStream();
				
				//发送状态行
				String line = "HTTP/1.1 200 OK";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应头
				line = "Content-Type: text/html";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				line = "Content-Length:" + file.length();//文件的字节量
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				//单独发送CRLF，表示响应头部分结束
				out.write(13);//written CR
				out.write(10);//written LF
				
				//发送响应正文
				FileInputStream fis = new FileInputStream(file);
				byte[] data = new byte[1024*10];
				int len = -1;
				while((len = fis.read(data))!=-1) {
					out.write(data, 0, len);
				}
				
			}else {
				System.out.println("该资源不存在");
			}
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
