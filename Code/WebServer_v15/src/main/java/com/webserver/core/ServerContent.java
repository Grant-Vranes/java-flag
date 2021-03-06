package com.webserver.core;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	服务端相关配置信息
 * @author Grant·Vranes
 *
 */
public class ServerContent {
	/*
	 * 	Servlet映射关系
	 * 	key：请求路径
	 * 	value：servlet的名字
	 */
	private static Map<String, String> servletMapping = new HashMap<String, String>();
	
	static {
		initServletMapping();
	}
	
	/**
	 * 	初始化Servlet映射
	 */
	private static void initServletMapping() {
//		servletMapping.put("/myweb/reg", "com.webserver.servlets.RegServlet");
//		servletMapping.put("/myweb/login", "com.webserver.servlets.LoginServlet");
//		servletMapping.put("/myweb/update", "com.webserver.servlets.UpdateServlet");
		/*
		 * 	加载conf/servlets.xml文件初始化
		 */
		try {
			SAXReader reader= new SAXReader();
			Document doc = reader.read(new File("conf/servlets.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for (Element servletEle : list) {
				String url = servletEle.attributeValue("url");
				String className = servletEle.attributeValue("className");
				servletMapping.put(url, className);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	根据请求路径获取对应的Servlet名字
	 * @param utl
	 * @return
	 */
	public static String getServletName(String url) {
		return servletMapping.get(url);
	}
}
