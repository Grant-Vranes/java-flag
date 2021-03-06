package com.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 	Http协议相关内容定义
 * @author Grant·Vranes
 *
 */
public class HttpContext {
	/**
	 * 回车符CR
	 */
	public static final int CR = 13;
	/**
	 * 换行符LF
	 */
	public static final int LF = 10;
	
	/*
	 * 	状态代码与对应状态描述
	 * 	key:状态代码
	 * 	value:状态描述
	 */
	private static Map<Integer, String> status_code_reason_mapping = new HashMap<>(); 
	
	/*
	 * 	介质类型映射
	 * 	Key:资源后缀名
	 * 	value:介质类型(Content-Type对应的值)
	 */
	private static Map<String, String> mime_mapping = new HashMap<String, String>();
	
	static {
		//初始化静态成员
		initstatusMapping();
		initMimeMapping();
	}
	
	/**
	 * 	初始化状态代码与对应描述
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
	 * 初始化介质类型
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
	 * 	根据状态代码获取对应的状态描述
	 * @param code
	 * @return
	 */
	public static String getStatusReason(int code) {
		return status_code_reason_mapping.get(code);
	}
	
	/**
	 *  根据资源后缀获取对应的介质类型
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
