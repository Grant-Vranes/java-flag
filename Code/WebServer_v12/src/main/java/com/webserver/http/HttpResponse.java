package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	//״̬����
	private int statusCode = 200;
	//״̬����
	private String statusReason = "OK";
	/*
	 * 	��Ӧͷ�����Ϣ����
	 */
	private Map<String, String> headers = new HashMap<>();
	
	
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
			String line = "HTTP/1.1 " + statusCode + " " + statusReason;
			println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	������Ӧͷ
	 */
	private void sendHeaders() {
		try {
			//����headers����������Ӧͷ����
			Set<Entry<String,String>> set = headers.entrySet();
			for (Entry<String, String> header : set) {
				String key = header.getKey();
				String value = header.getValue();
				String line = key + ":" + value;
				out.write(line.getBytes("ISO8859-1"));
				out.write(13);//written CR
				out.write(10);//written LF
			}
			
			//��������CRLF����ʾ��Ӧͷ���ֽ���
//			out.write(13);//written CR
//			out.write(10);//written LF
			println("");
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

	//������һЩget��set����
	public File getEntity() {
		return entity;
	}

	/**
	 * 	������Ӧʵ���ļ��������õ�ͬʱ������ļ������Զ����Ӷ�Ӧ
	 * 	��Conten-Type��Content-Length��������Ӧͷ��
	 * @param entity
	 */
	public void setEntity(File entity) {
		this.entity = entity;
		//���ݸ������ļ��Զ����ö�Ӧ��Content-Type��Content-Length
		this.headers.put("Content-Length", entity.length()+"");
		//��ȡ��Դ��׺����ȥHttpContext�л�ȡ��Ӧ�Ľ�������
		//��ȡ��Դ�ļ���
		String fileName = entity.getName();
		int index = fileName.lastIndexOf(".")+1;
		String ext = fileName.substring(index);
		String contentType = HttpContext.getMimeType(ext);
		
		
		this.headers.put("Content-Type", contentType);//����File�ļ��ĺ�׺ȥ�ж�
		/* ��׺	Content-Type
		 * html text/html
		 * png	image/png
		 * gif	image/gif
		 * jpg	image/jpeg
		 * js	application/javascript
		 * css	text/css
		 */
		
	}

	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * 	 ����״̬���룬���ú���Զ�����Ӧ���������ú�
	 * @param statusCode
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		this.statusReason = HttpContext.getStatusReason(statusCode);
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	//headers��get����
	public Map<String, String> getHeaders() {
		return headers;
	}
	
	/**
	 * 	����ָ������Ӧͷ��Ϣ
	 * @param name ��Ӧͷ������
	 * @param value	��Ӧͷ��Ӧ��ֵ
	 */
	public void putHeader(String name, String value) {
		this.headers.put(name, value);
	}
	
	/**
	 * ��ͻ��˷���һ���ַ���(��CRLF��β)
	 * ���ͺ���Զ�����CR,LF
	 * @param line
	 */
	private void println(String line) {
		try {
			out.write(line.getBytes("ISO8859-1"));
			out.write(HttpContext.CR);//written CR
			out.write(HttpContext.LF);//written LF
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}