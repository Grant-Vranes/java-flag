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
		/*
		 * 	解析conf/web.xml文件，将标签中所有名为<mime-mapping>
		 * 	的子标签获取到，并将该标签中的子标签<extension>中间的文本
		 * 	作为key，子标签<mime-type>中间的文本作为value保存到mime-mapping
		 * 	这个Map中完成初始化工作。
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
//		String reason = getStatusReason(404);
//		System.out.println(reason);
//		initMimeMapping();
	}
}
