package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 	请求对象
 * 	每个实例表示客户端发送过来的一个具体请求
 * @author Grant·Vranes
 *
 */
public class HttpRequest {
	/*
	 * 	请求行相关信息定义
	 */
	//请求方式
	private String method;
	//资源路径
	private String url;
	//协议版本
	private String protocol;
	
	/*
	 * 	消息头相关信息定义
	 */
	private Map<String, String> headers = new HashMap<String, String>();
		
	/*
	 * 	消息正文相关信息定义
	 */
	
	
	//客户端连接相关信息
	private Socket socket;
	private InputStream in;
	
	/**
	 * 	初始化请求
	 */
	public HttpRequest(Socket socket) {
		try {
			this.socket = socket;
			this.in = socket.getInputStream();
			/*
			 * 	解析请求
			 * 	1：解析请求行
			 * 	2：解析消息头
			 * 	3：解析消息正文
			 */
			parseRequestLine();
			parseHeaders();
			parseContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	解析请求行
	 */
	private void parseRequestLine() {
		System.out.println("开始解析请求行...");
		try {
			String line = readLine();
			System.out.println("请求行" + line);
			/*
			 * 	将请求行进行拆分，将每部分内容对应的设置到属性上
			 * 	字符串的split方法就可以拆
			 * 
			 * 	以下代码在后期运行过程中可能会出现数组下标越界的情况。
			 * 	这是由于HTTP协议允许客户端发送一个空请求过来，而这时
			 * 	通过空格拆分后是得不到三项内容的。V7版本解决
			 */
			String[] data = line.split("\\s");//  \s表示空格
			method = data[0];
			url = data[1];
			protocol = data[2];
			System.out.println("method:"+method);
			System.out.println("url:"+url);
			System.out.println("protocol:"+protocol);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("请求行解析完毕！");
	}
	
	/**
	 * 	解析消息头
	 */
	private void parseHeaders() {
		System.out.println("开始解析消息头...");
		try {
			 /*
			  * 	解析消息头的流程：
			  * 	循环调用readLine()方法，读取每一个消息头
			  * 	当readLine方法返回值为空字符串时停止循环
			  * 	（因为返回空字符串说明连续读取到了CRLF CRLF，但是
			  * 	之前什么字符也没有读到，而这是作为消息头结束的标志）
			  * 	比如：
			  * 	Accept-Language: zh-CN,zh;q=0.9(CRLF)(CRLF)
			  * 
			  * 	在读取到每个消息头后，根据": "（冒号空格）进行拆分，
			  * 	并将消息头的名字作为key，消息头对应的值作为value
			  * 	保存到属性headers这个Map中完成解析工作
			  */
			while(true) {	
				String line = readLine();
				if("".equals(line)) {
					break;
				}
				String[] data = line.split(":\\s");
				headers.put(data[0], data[1]);
			}
			System.out.println("headers:" + headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("请求消息头解析完毕！");
	}
	
	/**
	 * 	解析消息正文
	 */
	private void parseContent() {
		System.out.println("开始解析消息正文...");
		
		System.out.println("请求消息正文解析完毕！");
	}
	
	/**
	 * 	读取一行字符串，当连续读取CR，LF时停止并将之前的内容
	 * 	以一行字符串形式返回
	 */
	private String readLine() throws IOException {
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

	/*	设置get方法，可以让别的类获取信息；但不提供set方法，
	 * 	因为这些信息都来自客户端发送的请求，一般不修改
	 */
	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getProtocol() {
		return protocol;
	}
	/**
	 * 	根据给定的消息头的名字获取对应消息头的值
	 * 	因为消息头相关信息headers是private的，所以外界想要获取可以给一个get方法
	 * @param name
	 * @return
	 */
	public String getHeader(String name) {
		return headers.get(name);
	}
}
