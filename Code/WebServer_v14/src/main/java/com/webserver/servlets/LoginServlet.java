package com.webserver.servlets;

import java.io.File;
import java.io.RandomAccessFile;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
/**
 * 	处理登录业务
 * @author Grant·Vranes
 *
 */
public class LoginServlet extends HttpServlet{
	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("处理登录业务！！！");
		/*
		 * 	注册大致流程:
		 * 	1:获取用户提交的登录信息
		 * 	2：查询文件user.dat，若找到对应信息并验证正确，响应客户端登录成功的页面
		 * 	3:若找不到对应信息，则响应客户端登录失败的页面
		 */
		//1
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("登录信息:"+username+":"+password);
		
		//2
		try (
			RandomAccessFile raf = new RandomAccessFile("user.dat", "r");
		){
			//默认登陆失败
			boolean flag = false;
			//遍历每条记录
			for (int i = 0; i < raf.length()/100; i++) {
				//移动指针到当前记录的开始位置
				raf.seek(i*100);
				//读取用户名
				byte[] data = new byte[32];
				raf.read(data);
				String username_true = new String(data, "UTF-8").trim();
				
				if(username.equals(username_true)) {
					//读取密码
					raf.read(data);
					String password_true = new String(data, "UTF-8").trim();
					if(password_true.equals(password)) {
						//登陆成功
						flag = true;
					}
					//用户名唯一，只要用户名对上了，不管密码对不对，都会返回
					break;
				} 
			}
			if(!flag) {
				//response.setEntity(new File("webapps/myweb/login_fail.html"));
				forward("/myweb/login_fail.html", request, response);
			} else {
				//response.setEntity(new File("webapps/myweb/login_success.html"));
				forward("/myweb/login_success.html", request, response);
			}
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
