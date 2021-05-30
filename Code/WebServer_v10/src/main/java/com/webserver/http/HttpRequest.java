package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.webserver.core.EmptyRequestException;

/**
 * 	�������
 * 	ÿ��ʵ����ʾ�ͻ��˷��͹�����һ����������
 * @author Grant��Vranes
 *
 */
public class HttpRequest {
	/*
	 * 	�����������Ϣ����
	 */
	//����ʽ
	private String method;
	//��Դ·��
	private String url;
	//Э��汾
	private String protocol;
	
	/*
	 * 	��Ϣͷ�����Ϣ����
	 */
	private Map<String, String> headers = new HashMap<String, String>();
		
	/*
	 * 	��Ϣ���������Ϣ����
	 */
	
	
	//�ͻ������������Ϣ
	private Socket socket;
	private InputStream in;
	
	/**
	 * 	��ʼ������
	 * @throws EmptyRequestException 
	 */
	public HttpRequest(Socket socket) throws EmptyRequestException {
		try {
			this.socket = socket;
			this.in = socket.getInputStream();
			/*
			 * 	��������
			 * 	1������������
			 * 	2��������Ϣͷ
			 * 	3��������Ϣ����
			 */
			parseRequestLine();
			parseHeaders();
			parseContent();
		} catch(EmptyRequestException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	����������
	 * @throws EmptyRequestException 
	 */
	private void parseRequestLine() throws EmptyRequestException {
		System.out.println("��ʼ����������...");
		try {
			String line = readLine();
			System.out.println("������" + line);
			/*
			 * 	�������н��в�֣���ÿ�������ݶ�Ӧ�����õ�������
			 * 	�ַ�����split�����Ϳ��Բ�
			 * 
			 * 	���´����ں������й����п��ܻ���������±�Խ��������
			 * 	��������HTTPЭ�������ͻ��˷���һ�����������������ʱ
			 * 	ͨ���ո��ֺ��ǵò����������ݵġ��ð汾�Ѿ����
			 */
			String[] data = line.split("\\s");//  \s��ʾ�ո�
			if(data.length != 3) {
				//data�����ֺ������Σ��ж��ǿ�����
				throw new EmptyRequestException();
			}
			
			method = data[0];
			url = data[1];
			protocol = data[2];
			System.out.println("method:"+method);
			System.out.println("url:"+url);
			System.out.println("protocol:"+protocol);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("�����н�����ϣ�");
	}
	
	/**
	 * 	������Ϣͷ
	 */
	private void parseHeaders() {
		System.out.println("��ʼ������Ϣͷ...");
		try {
			 /*
			  * 	������Ϣͷ�����̣�
			  * 	ѭ������readLine()��������ȡÿһ����Ϣͷ
			  * 	��readLine��������ֵΪ���ַ���ʱֹͣѭ��
			  * 	����Ϊ���ؿ��ַ���˵��������ȡ����CRLF CRLF������
			  * 	֮ǰʲô�ַ�Ҳû�ж�������������Ϊ��Ϣͷ�����ı�־��
			  * 	���磺
			  * 	Accept-Language: zh-CN,zh;q=0.9(CRLF)(CRLF)
			  * 
			  * 	�ڶ�ȡ��ÿ����Ϣͷ�󣬸���": "��ð�ſո񣩽��в�֣�
			  * 	������Ϣͷ��������Ϊkey����Ϣͷ��Ӧ��ֵ��Ϊvalue
			  * 	���浽����headers���Map����ɽ�������
			  */
			while(true) {	
				String line = readLine();
				if("".equals(line)) {
					break;
				}
				String[] data = line.split(":\\s");
				headers.put(data[0], data[1]);
			}
			System.out.println("headers:" + headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("������Ϣͷ������ϣ�");
	}
	
	/**
	 * 	������Ϣ����
	 */
	private void parseContent() {
		System.out.println("��ʼ������Ϣ����...");
		
		System.out.println("������Ϣ���Ľ�����ϣ�");
	}
	
	/**
	 * 	��ȡһ���ַ�������������ȡCR��LFʱֹͣ����֮ǰ������
	 * 	��һ���ַ�����ʽ����
	 */
	private String readLine() throws IOException {
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
			if(c1==HttpContext.CR && c2==HttpContext.LF) {//��ʱ����CR��LF˵��һ�ж�����ĩβ
				break;
			}
			builder.append(c2);
			c1 = c2;//�ѱ����ַ�������һ���ַ�
		}
		//CR��LF�����ǿո����trim()����ȥ��
		return builder.toString().trim();
	}

	/*	����get�����������ñ�����ȡ��Ϣ�������ṩset������
	 * 	��Ϊ��Щ��Ϣ�����Կͻ��˷��͵�����һ�㲻�޸�
	 */
	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getProtocol() {
		return protocol;
	}
	/**
	 * 	���ݸ�������Ϣͷ�����ֻ�ȡ��Ӧ��Ϣͷ��ֵ
	 * 	��Ϊ��Ϣͷ�����Ϣheaders��private�ģ����������Ҫ��ȡ���Ը�һ��get����
	 * @param name
	 * @return
	 */
	public String getHeader(String name) {
		return headers.get(name);
	}
}