package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter{
	private FilterConfig config;
	/**
	 * 容器启动之后，会立即创建过滤器实例。
	 * 注：只会创建一个实例！
	 */
	public CommentFilter() {
		System.out.println("CommentFilter的构造器创建了");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 容器在调用完过滤器的init方法之后，会调用doFilter方法来处理请求
	 * 注：（了解）
	 * 	ServletRequest是HttpServletRequest的父接口，ServletResponse
	 * 	是HttpServletResponse的父接口。
	 * 
	 * FilterChain（过滤器链）
	 * 		如果调用了该对象的doFilter方法，表示继续向后调用；否则，中断请求，
	 * 		返回处理结果。
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("CommentFilter的doFilter方法开始执行");
		/*
		 * 因为sun公司过度设计，这里需要做强制转换（我们经常调用的是子接口中的方法）
		 */
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		//读取初始化参数
		int size = Integer.parseInt(config.getInitParameter("size"));
		if(content.indexOf("狗") != -1) {
			//包含敏感词，不再向后调用
			//返回处理结果
			out.println("评论包含了敏感词");
		}else {
			//没有敏感词，继续向后调用
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("CommentFilter的doFilter方法执行完毕");
	}

	/**
	 * 容器在创建好过滤器实例之后，会立即调用该实例的init方法
	 * 注：该方法只会调用一次！
	 */
	public void init(FilterConfig arg0) throws ServletException {
		//将容器传递过来的FilterConfig对象保存下来
		config = arg0;
		System.out.println("CommentFilter的初始化方法");
	}

}
