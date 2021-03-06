package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.webserver.core.EmptyRequestException;

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
	
	//url中的请求部分
	private String requestURI;
	//url中的参数部分
	private String QueryString;
	//每个参数
	private Map<String, String> parameters = new HashMap<String, String>();
	
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
	 * @throws EmptyRequestException 
	 */
	public HttpRequest(Socket socket) throws EmptyRequestException {
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
		} catch(EmptyRequestException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	解析请求行
	 * @throws EmptyRequestException 
	 */
	private void parseRequestLine() throws EmptyRequestException {
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
			 * 	通过空格拆分后是得不到三项内容的。该版本已经解决
			 */
			String[] data = line.split("\\s");//  \s表示空格
			if(data.length != 3) {
				//data数组拆分后不足三段，判定是空请求
				throw new EmptyRequestException();
			}
			
			method = data[0];
			url = data[1];
			//进一步解析url
			parseURL();
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
	 * 	进一步解析URL
	 * 	url有可能会有两种格式：带参数和不带参数
	 * 	1,不带参数如：/myweb/index.html
	 * 	2,带参如:/myweb/reg?username=zhangsan&password=123
	 */
	private void parseURL() {
		/*
		 * 	首先判断当前url是否含有参数，判断的一句是看url是否含有“?”,
		 * 	含有则认为这个url是包含参数的，否则直接将url赋值给requestURI即可
		 * 
		 * 	若有参数：
		 * 	1：将url按照“?”拆分为两部分，第一部分为请求部分，赋值给requestURI
		 * 		第二部分为参数部分，赋值给queryString
		 * 	2：再对queryString进一步拆分，先按照“&”拆分出参数名和参数值，并存入
		 * 		parameters这个Map中
		 * 
		 * 	解析过程中要注意url的几个特别情况：
		 * 	1：url可能含有“?” 但是没有参数部分，如:/myweb/reg?
		 * 	2：参数部分有可能只有参数名没有参数值，如:/myweb/reg?username=&password=
		 */
		if(url.indexOf("?") != -1) {
			//按照“?”拆分
			String[] data = url.split("\\?");
			requestURI = data[0];
			//判断?后面是否有参数,判断第一种例外情况
			if(data.length > 1) {
				QueryString = data[1];
				//进一步解析参数部分，按照&拆分出每一个参数
				String[] paraArr = QueryString.split("&");
				//遍历每个参数进行拆分
				for (String para : paraArr) {
					//再按照“=”拆分每个参数
					String[] paras = para.split("=");
					if(paras.length > 1) {
						//该参数有值
						parameters.put(paras[0], paras[1]);
					} else {
						//没有值
						parameters.put(paras[0], null);
					}
				}
			}
		}else {
			//不含有?
			requestURI = url;
		}
		System.out.println("requestURI:" + requestURI);
		System.out.println("queryString:" + QueryString);
		System.out.println("paramenters:" + parameters);
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
			if(c1==HttpContext.CR && c2==HttpContext.LF) {//此时读到CR，LF说明一行读到了末尾
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

	public String getRequestURI() {
		return requestURI;
	}

	public String getQueryString() {
		return QueryString;
	}
	
	/**
	 * 	根据给定的参数名获取对应的参数值
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		return parameters.get(name);
	}
}
