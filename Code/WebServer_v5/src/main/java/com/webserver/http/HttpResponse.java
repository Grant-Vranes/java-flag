package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 	响应对象
 * 	该类中的每一个实例用于表示一个具体要给客户端响应的内容
 * 	一个响应包含：
 * 	状态行，响应头，响应正文
 * @author Grant·Vranes
 *
 */
public class HttpResponse {
	/*
	 * 	状态行相关信息定义
	 */
	
	/*
	 * 	响应头相关信息定义
	 */
	
	/*
	 * 	响应正文相关信息定义
	 */
	//响应的实体文件
	private File entity;
	
	//连接相关信息定义
	private Socket socket;
	private OutputStream out;
	public HttpResponse(Socket socket) {
		try {
			this.socket = socket;
			this.out = socket.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	将当前响应内容发送给客户端
	 */
	public void flush() {
		/*
		 * 	响应客户端
		 * 	1：发送状态行
		 *	2：发送响应头
		 *	3：发送响应正文
		 */
		try {
			sendStatusLine();
			sendHeaders();
			sendContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	发送状态行
	 */
	private void sendStatusLine() {
		try {
			String line = "HTTP/1.1 200 OK";
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	发送响应头
	 */
	private void sendHeaders() {
		try {
			String line = "Content-Type: text/html";
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
			
			line = "Content-Length:" + entity.length();//文件的字节量
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
			//单独发送CRLF，表示响应头部分结束
			out.write(13);//written CR
			out.write(10);//written LF
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	发送响应正文
	 */
	private void sendContent() {
		try (//用完就关闭的流放在这里
				FileInputStream fis = new FileInputStream(entity);	
				){
			byte[] data = new byte[1024*10];
			int len = -1;
			while((len = fis.read(data))!=-1) {
				out.write(data, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File getEntity() {
		return entity;
	}

	public void setEntity(File entity) {
		this.entity = entity;
	}
	
	
}
