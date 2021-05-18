package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 	��Ӧ����
 * 	�����е�ÿһ��ʵ�����ڱ�ʾһ������Ҫ���ͻ�����Ӧ������
 * 	һ����Ӧ������
 * 	״̬�У���Ӧͷ����Ӧ����
 * @author Grant��Vranes
 *
 */
public class HttpResponse {
	/*
	 * 	״̬�������Ϣ����
	 */
	
	/*
	 * 	��Ӧͷ�����Ϣ����
	 */
	
	/*
	 * 	��Ӧ���������Ϣ����
	 */
	//��Ӧ��ʵ���ļ�
	private File entity;
	
	//���������Ϣ����
	private Socket socket;
	private OutputStream out;
	public HttpResponse(Socket socket) {
		try {
			this.socket = socket;
			this.out = socket.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	����ǰ��Ӧ���ݷ��͸��ͻ���
	 */
	public void flush() {
		/*
		 * 	��Ӧ�ͻ���
		 * 	1������״̬��
		 *	2��������Ӧͷ
		 *	3��������Ӧ����
		 */
		try {
			sendStatusLine();
			sendHeaders();
			sendContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	����״̬��
	 */
	private void sendStatusLine() {
		try {
			String line = "HTTP/1.1 200 OK";
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	������Ӧͷ
	 */
	private void sendHeaders() {
		try {
			String line = "Content-Type: text/html";
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
			
			line = "Content-Length:" + entity.length();//�ļ����ֽ���
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);//written CR
			out.write(10);//written LF
			//��������CRLF����ʾ��Ӧͷ���ֽ���
			out.write(13);//written CR
			out.write(10);//written LF
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	������Ӧ����
	 */
	private void sendContent() {
		try (//����͹رյ�����������
				FileInputStream fis = new FileInputStream(entity);	
				){
			byte[] data = new byte[1024*10];
			int len = -1;
			while((len = fis.read(data))!=-1) {
				out.write(data, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public File getEntity() {
		return entity;
	}

	public void setEntity(File entity) {
		this.entity = entity;
	}
	
	
}
