package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
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
	
	//url�е����󲿷�
	private String requestURI;
	//url�еĲ�������
	private String QueryString;
	//ÿ������
	private Map<String, String> parameters = new HashMap<String, String>();
	
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
			//��һ������url
			parseURL();
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
	 * 	��һ������URL
	 * 	url�п��ܻ������ָ�ʽ���������Ͳ�������
	 * 	1,���������磺/myweb/index.html
	 * 	2,������:/myweb/reg?username=zhangsan&password=123
	 */
	private void parseURL() {
		/*
		 * 	�����жϵ�ǰurl�Ƿ��в������жϵ�һ���ǿ�url�Ƿ��С�?��,
		 * 	��������Ϊ���url�ǰ��������ģ�����ֱ�ӽ�url��ֵ��requestURI����
		 * 
		 * 	���в�����
		 * 	1����url���ա�?�����Ϊ�����֣���һ����Ϊ���󲿷֣���ֵ��requestURI
		 * 		�ڶ�����Ϊ�������֣���ֵ��queryString
		 * 	2���ٶ�queryString��һ����֣��Ȱ��ա�&����ֳ��������Ͳ���ֵ��������
		 * 		parameters���Map��
		 * 
		 * 	����������Ҫע��url�ļ����ر������
		 * 	1��url���ܺ��С�?�� ����û�в������֣���:/myweb/reg?
		 * 	2�����������п���ֻ�в�����û�в���ֵ����:/myweb/reg?username=&password=
		 */
		if(url.indexOf("?") != -1) {
			//���ա�?�����
			String[] data = url.split("\\?");
			requestURI = data[0];
			//�ж�?�����Ƿ��в���,�жϵ�һ���������
			if(data.length > 1) {
				QueryString = data[1];
				//��һ��������������
				parseParameter(QueryString);
			}
		}else {
			//������?
			requestURI = url;
		}
		System.out.println("requestURI:" + requestURI);
		System.out.println("queryString:" + QueryString);
		System.out.println("paramenters:" + parameters);
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
		/*
		 * 	������Ϣͷ�Ƿ���Content-Length�����������Ƿ�����Ϣ���� 
		 */
		try {
			if(headers.containsKey("Content-Length")) {
				//������Ϣ����
				int length = Integer.parseInt(
						headers.get("Content-Length")
				);
				//��ȡ��Ϣ��������
				byte[] data = new byte[length];
				in.read(data);
				
				/*
				 * 	������ϢͷContent-Type�жϸ���Ϣ���ĵ���������
				 */
				String contentType = headers.get("Content-Type");
				//�ж��Ƿ�Ϊform�����ύ����
				if("application/x-www-form-urlencoded".equals(contentType)) {
					/*
					 * 	�����������൱��ԭGET�����е�ַ����url�С�?���Ҳ�����
					 */
					String line = new String(data, "ISO8859-1");
					System.out.println("�������ݣ�"+line);
					parseParameter(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("������Ϣ���Ľ�����ϣ�");
	}
	
	/**
	 * 	��������
	 * 	��ʽ��name=value&name=value&...
	 * @param line
	 */
	private void parseParameter(String line) {
		/*
		 * 	�Ƚ������е�"%XX"�����ݰ��ն�Ӧ�ַ����������ͨ����UTF-8����ԭΪ��Ӧ����
		 */
		try {
			/*
			 * 	URLDecoder�� decode�������Խ��������ַ�����
			 * 	��"%XX"����תΪ��Ӧ2�����ֽ�Ȼ���ո������ַ���
			 * 	����Щ�ֽڻ�ԭΪ��Ӧ�ַ����滻��Щ"%XX"���֣�Ȼ��
			 * 	�����õ��ַ�������
			 * 	����line������Ϊ��
			 * 	username=%E5%88%98%E7%91%9C%E6%BE%84&password=123
			 * 	ת����Ϻ�Ϊ��
			 * 	username=��褳�&password=123
			 */
			System.out.println("�Բ���ת��ǰ:"+line);
			line = URLDecoder.decode(line, "UTF-8");
			System.out.println("�Բ���ת���:"+line);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//��һ�������������֣�����&��ֳ�ÿһ������
		String[] paraArr = line.split("&");
		//����ÿ���������в��
		for (String para : paraArr) {
			//�ٰ��ա�=�����ÿ������
			String[] paras = para.split("=");
			if(paras.length > 1) {
				//�ò�����ֵ
				parameters.put(paras[0], paras[1]);
			} else {
				//û��ֵ
				parameters.put(paras[0], null);
			}
		}
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

	public String getRequestURI() {
		return requestURI;
	}

	public String getQueryString() {
		return QueryString;
	}
	
	/**
	 * 	���ݸ����Ĳ�������ȡ��Ӧ�Ĳ���ֵ
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		return parameters.get(name);
	}
}