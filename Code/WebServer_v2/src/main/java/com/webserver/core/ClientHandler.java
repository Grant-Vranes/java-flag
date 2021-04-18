package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

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
			InputStream in = socket.getInputStream();
			String line = readLine(in);
			System.out.println(line);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	��ȡһ���ַ�������������ȡCR��LFʱֹͣ����֮ǰ������
	 * 	��һ���ַ�����ʽ����
	 */
	private String readLine(InputStream in) throws IOException {
		//����һ��StringBuilder����׼�����ַ���ƴ��
		StringBuilder builder = new StringBuilder();
		//���ζ�ȡ���ֽ�
		int d = -1;
		//c1��ʾ�ϴζ�ȡ���ַ���c2��ʾ���ζ�ȡ���ַ�
		char c1 = 'a', c2 = 'a';
		while((d=in.read())!=-1) {
			c2 = (char)d;
			/*
			 * 	CR:�س��� ASC�����Ӧֵ��13 ----------���ص��ʼ
	         *	LF:���з� ASC�����Ӧֵ��10 ----------��껻����һ��
			 */
			if(c1==13 && c2==10) {//��ʱ����CR��LF˵��һ�ж�����ĩβ
				break;
			}
			builder.append(c2);
			c1 = c2;//�ѱ����ַ�������һ���ַ�
		}
		//CR��LF�����ǿո����trim()����ȥ��
		return builder.toString().trim();
	}
}