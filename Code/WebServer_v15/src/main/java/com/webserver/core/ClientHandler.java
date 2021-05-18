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
 * 	�ͻ��˴�����
 * 	����ͻ�������
 * @author Grant��Vranes
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	 
	public ClientHandler(Socket socket) {//�вι���
		this.socket = socket;
	}
	public void run() {
		/*
		 * 	����������������Ƿ��������ͻ�����Ƿ���һ����׼
		 * 	��http�������ݹ�������ô����Ϳ����ͻ������������ʲô
		 */
		try {
			/*
			 * 	�����̣�
			 * 	1����������
			 * 	2����������
			 * 	3��������Ӧ
			 */
			//1:׼������
			//1.1�������󣬴����������
			HttpRequest request = new HttpRequest(socket);
			//1.2������Ӧ����
			HttpResponse response = new HttpResponse(socket);
			
			//2:��������
			//2.1����ȡ�������Դ·��
			String url = request.getRequestURI();
			//System.out.println("============="+url);
			
			//�жϸ������Ƿ�Ϊ����ҵ��
			String servletName = ServerContent.getServletName(url);
			if(servletName != null) {
				//ʹ��ӳ����
				System.out.println("ӳ�䣺" + servletName);
				Class cls = Class.forName(servletName);
				HttpServlet servlet = (HttpServlet)cls.newInstance();
				servlet.service(request, response);
			} else {
				//2.2:������Դ·��ȥwebappsĿ¼��Ѱ�Ҹ���Դ
				File file = new File("webapps"+url);
				if(file.exists()) {
					System.out.println("�ҵ�����Դ");
					//����Ӧ����������Ҫ��Ӧ����Դ����
					response.setEntity(file);
				}else {
					//����״̬����404
					response.setStatusCode(404);
					//����404ҳ��
					response.setEntity(new File("webapps/root/404.html"));
					System.out.println("��Դ������");
				}
			}
			
			//3:��Ӧ�ͻ���
			response.flush();
			
		} catch(EmptyRequestException e) {
			/*
			 * 	ʵ����HttpRequestʱ�������ǿ�����ʱ���ù��췽���Ὣ���쳣�׳���
			 * 	���ﲻ���κδ���ֱ����finally����ͻ��˶Ͽ����ɣ������Ͳ���
			 * 	���������±�Խ��
			 */
			System.out.println("������");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//��ͻ��˶Ͽ�����
			try {
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
