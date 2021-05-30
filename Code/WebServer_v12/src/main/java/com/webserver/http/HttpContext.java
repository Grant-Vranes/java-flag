package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	HttpЭ��������ݶ���
 * @author Grant��Vranes
 *
 */
public class HttpContext {
	/**
	 * �س���CR
	 */
	public static final int CR = 13;
	/**
	 * ���з�LF
	 */
	public static final int LF = 10;
	
	/*
	 * 	״̬�������Ӧ״̬����
	 * 	key:״̬����
	 * 	value:״̬����
	 */
	private static Map<Integer, String> status_code_reason_mapping = new HashMap<>(); 
	
	/*
	 * 	��������ӳ��
	 * 	Key:��Դ��׺��
	 * 	value:��������(Content-Type��Ӧ��ֵ)
	 */
	private static Map<String, String> mime_mapping = new HashMap<String, String>();
	
	static {
		//��ʼ����̬��Ա
		initstatusMapping();
		initMimeMapping();
	}
	
	/**
	 * 	��ʼ��״̬�������Ӧ����
	 */
	private static void initstatusMapping() {
		status_code_reason_mapping.put(200, "OK");
		status_code_reason_mapping.put(201, "Created");
		status_code_reason_mapping.put(202, "Accepted");
		status_code_reason_mapping.put(204, "No Content");
		status_code_reason_mapping.put(301, "Moved Permanently");
		status_code_reason_mapping.put(302, "Moved Temporarily");
		status_code_reason_mapping.put(304, "Not Modified");
		status_code_reason_mapping.put(400, "Bad Request");
		status_code_reason_mapping.put(401, "Unauthorized");
		status_code_reason_mapping.put(403, "Forbidden");
		status_code_reason_mapping.put(404, "Not Found");
		status_code_reason_mapping.put(500, "Internal Server Error");
		status_code_reason_mapping.put(501, "Not Implemented");
		status_code_reason_mapping.put(502, "Bad Gateway");
		status_code_reason_mapping.put(503, "Service Unavailable");
	}
	
	/**
	 * ��ʼ����������
	 */
	private static void initMimeMapping() {
		/*
		 * 	����conf/web.xml�ļ�������ǩ��������Ϊ<mime-mapping>
		 * 	���ӱ�ǩ��ȡ���������ñ�ǩ�е��ӱ�ǩ<extension>�м���ı�
		 * 	��Ϊkey���ӱ�ǩ<mime-type>�м���ı���Ϊvalue���浽mime-mapping
		 * 	���Map����ɳ�ʼ��������
		 */
		try {
			SAXReader reader = new SAXReader();
			//Document doc = reader.read(new FileInputStream("conf/web.xml"));
			Document doc = reader.read(new File("conf/web.xml"));
			Element root = doc.getRootElement();
			List<Element> mimeList = root.elements("mime-mapping");
			for (Element mimeEle: mimeList) {
				String extensionEle = mimeEle.elementText("extension");
				String mime_typeEle = mimeEle.elementText("mime-type");
				mime_mapping.put(extensionEle, mime_typeEle);
			}
//			System.out.println(mime_mapping.size());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	����״̬�����ȡ��Ӧ��״̬����
	 * @param code
	 * @return
	 */
	public static String getStatusReason(int code) {
		return status_code_reason_mapping.get(code);
	}
	
	/**
	 *  ������Դ��׺��ȡ��Ӧ�Ľ�������
	 * @param ext
	 * @return
	 */
	public static String getMimeType(String ext){
		return mime_mapping.get(ext);
	}
	
	public static void main(String[] args) {
//		String reason = getStatusReason(404);
//		System.out.println(reason);
//		initMimeMapping();
	}
}