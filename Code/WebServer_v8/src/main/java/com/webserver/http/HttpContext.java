package com.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 	HttpЭ��������ݶ���
 * @author Grant��Vranes
 *
 */
public class HttpContext {
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
		mime_mapping.put("html", "text/html");
		mime_mapping.put("png", "image/png");
		mime_mapping.put("gif", "image/gif");
		mime_mapping.put("jpg", "image/jpg");
		mime_mapping.put("css", "text/css");
		mime_mapping.put("js", "application/javascript");
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
		String reason = getStatusReason(404);
		System.out.println(reason);
	}
}