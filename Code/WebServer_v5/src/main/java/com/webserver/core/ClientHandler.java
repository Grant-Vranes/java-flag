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
 * 	�ͻ��˴�����
 * 	�����ͻ�������
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
			String url = request.getUrl();
			//2.2:������Դ·��ȥwebappsĿ¼��Ѱ�Ҹ���Դ
			File file = new File("webapps"+url);
			if(file.exists()) {
				System.out.println("�ҵ�����Դ");
				//����Ӧ����������Ҫ��Ӧ����Դ����
				response.setEntity(file);
			}else {
				System.out.println("��Դ������");
			}
			//��Ӧ�ͻ���
			response.flush();
			
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