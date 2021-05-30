package com.webserver.servlets;

import java.io.File;
import java.io.RandomAccessFile;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
/**
 * 	������¼ҵ��
 * @author Grant��Vranes
 *
 */
public class LoginServlet extends HttpServlet{
	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("������¼ҵ�񣡣���");
		/*
		 * 	ע���������:
		 * 	1:��ȡ�û��ύ�ĵ�¼��Ϣ
		 * 	2����ѯ�ļ�user.dat�����ҵ���Ӧ��Ϣ����֤��ȷ����Ӧ�ͻ��˵�¼�ɹ���ҳ��
		 * 	3:���Ҳ�����Ӧ��Ϣ������Ӧ�ͻ��˵�¼ʧ�ܵ�ҳ��
		 */
		//1
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("��¼��Ϣ:"+username+":"+password);
		
		//2
		try (
			RandomAccessFile raf = new RandomAccessFile("user.dat", "r");
		){
			//Ĭ�ϵ�½ʧ��
			boolean flag = false;
			//����ÿ����¼
			for (int i = 0; i < raf.length()/100; i++) {
				//�ƶ�ָ�뵽��ǰ��¼�Ŀ�ʼλ��
				raf.seek(i*100);
				//��ȡ�û���
				byte[] data = new byte[32];
				raf.read(data);
				String username_true = new String(data, "UTF-8").trim();
				
				if(username.equals(username_true)) {
					//��ȡ����
					raf.read(data);
					String password_true = new String(data, "UTF-8").trim();
					if(password_true.equals(password)) {
						//��½�ɹ�
						flag = true;
					}
					//�û���Ψһ��ֻҪ�û��������ˣ���������Բ��ԣ����᷵��
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