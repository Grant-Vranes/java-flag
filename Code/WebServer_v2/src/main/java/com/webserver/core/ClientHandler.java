package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

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
			InputStream in = socket.getInputStream();
			String line = readLine(in);
			System.out.println(line);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	读取一行字符串，当连续读取CR，LF时停止并将之前的内容
	 * 	以一行字符串形式返回
	 */
	private String readLine(InputStream in) throws IOException {
		//创建一个StringBuilder对象准备做字符串拼接
		StringBuilder builder = new StringBuilder();
		//本次读取的字节
		int d = -1;
		//c1表示上次读取的字符，c2表示本次读取的字符
		char c1 = 'a', c2 = 'a';
		while((d=in.read())!=-1) {
			c2 = (char)d;
			/*
			 * 	CR:回车符 ASC编码对应值：13 ----------光标回到最开始
	         *	LF:换行符 ASC编码对应值：10 ----------光标换到下一行
			 */
			if(c1==13 && c2==10) {//此时读到CR，LF说明一行读到了末尾
				break;
			}
			builder.append(c2);
			c1 = c2;//把本次字符赋给上一次字符
		}
		//CR和LF都算是空格，最后trim()可以去除
		return builder.toString().trim();
	}
}
