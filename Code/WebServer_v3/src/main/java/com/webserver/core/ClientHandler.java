package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.webserver.http.HttpRequest;

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
			//1:��������
			HttpRequest request = new HttpRequest(socket);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
