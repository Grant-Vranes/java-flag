package com.webserver.core;

import java.io.InputStream;
import java.net.Socket;

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
			InputStream in = socket.getInputStream();
			int d = -1;
			while((d=in.read())!=-1) {
				char c = (char)d;
				System.out.print(c);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
