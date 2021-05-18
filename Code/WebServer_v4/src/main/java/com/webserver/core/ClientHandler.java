package com.webserver.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
			
			//2:��������
			//2.1����ȡ�������Դ·��
			String url = request.getUrl();
			//2.2:������Դ·��ȥwebappsĿ¼��Ѱ�Ҹ���Դ
			File file = new File("webapps"+url);
			if(file.exists()) {
				System.out.println("�ҵ�����Դ");
				//��Ӧ�ͻ��˸���Դ
				OutputStream out = socket.getOutputStream();
				
				//����״̬��
				String line = "HTTP/1.1 200 OK";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				//������Ӧͷ
				line = "Content-Type: text/html";
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				
				line = "Content-Length:" + file.length();//�ļ����ֽ���
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
				//��������CRLF����ʾ��Ӧͷ���ֽ���
				out.write(13);//written CR
				out.write(10);//written LF
				
				//������Ӧ����
				FileInputStream fis = new FileInputStream(file);
				byte[] data = new byte[1024*10];
				int len = -1;
				while((len = fis.read(data))!=-1) {
					out.write(data, 0, len);
				}
				
			}else {
				System.out.println("����Դ������");
			}
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
