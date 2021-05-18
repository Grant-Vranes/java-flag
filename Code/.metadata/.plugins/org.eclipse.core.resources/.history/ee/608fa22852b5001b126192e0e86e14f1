package com.webserver.servlets;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 	处理注册业务
 * @author Grant·Vranes
 *
 */
public class RegServlet {
	public void service(HttpRequest request, HttpResponse response) {
		/*
		 * 	注册大致流程:
		 * 	1:获取用户提交的注册信息
		 * 	2：将注册信息写入文件user.dat
		 * 	3:响应客户端注册成功的页面
		 */
		System.out.println("开始处理注册业务！！！");
		/*
		 * 	1
		 * 	通过request.getParameter()方法获取用户提交上来的数据时，传递的参数
		 * 	这个字符串的值应当是页面中form表单里对应的输入框的名字(name属性的值)
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("注册业务信息:"+username+password+nickname+age);//打桩测试
		
		/*
		 *  2
		 *  每条记录占100字节，其中用户名，密码，你何曾为字符串，各占32字节。
		 *  年龄为int值占4字节。写入到user.dat文件。
		 */
		try {
			RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
			/*	每次执行程序的时候（就是每写入一条数据记录的时候），指针都在开头，就
			 * 	造成每写一次之前写的就会被覆盖。所以每一次调用程序都重定指针的位置，使
			 * 	其居于末尾,接着后面写
			 */
			raf.seek(raf.length());
			
			//写用户名
			//1先将用户名转成对应的一组字节
			byte[] data = username.getBytes("UTF-8");
			//2将该数组扩容为32字节，无论用户名多大，多扩容成32字节，为了确保最后能完整的组成100字节
			data = Arrays.copyOf(data, 32);
			//3将该字节数组一次性写入文件
			raf.write(data);
			
			//写密码，data重新赋值
			data = password.getBytes("UTF-8");
			data = Arrays.copyOf(data,32);
			raf.write(data);
			
			//写昵称
			data = nickname.getBytes("UTF-8");
			data = Arrays.copyOf(data,32);
			raf.write(data);
			
			//写年龄
			raf.writeInt(age);
			System.out.println("注册完毕");
			
			//3响应客户端注册成功页面
			response.setEntity(new File("webapps/myweb/reg_success.html"));
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
