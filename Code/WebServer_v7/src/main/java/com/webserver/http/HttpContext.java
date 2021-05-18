package com.webserver.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 	Http协议相关内容定义
 * @author Grant·Vranes
 *
 */
public class HttpContext {
	/*
	 * 	状态代码与对应状态描述
	 * 	key:状态代码
	 * 	value:状态描述
	 */
	private static Map<Integer, String> status_code_reason_mapping = new HashMap<>(); 
	
	static {
		//初始化静态成员
		initstatusMapping();
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
	 * 	根据状态代码获取对应的状态描述
	 * @param code
	 * @return
	 */
	public static String getStatusReason(int code) {
		return status_code_reason_mapping.get(code);
	}
}
