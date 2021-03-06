package com.webserver.core;
//后来烟雨入盛京，一人撑伞两人行
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *	网页上输入http://localhost:8088/myweb/index.html
 * 	WebServer主类
 * @author Grant·Vranes
 *
 */
public class WebServer {
	private ServerSocket server;
	private ExecutorService threadPool;//加入线程池
	
	/*
	 * 	构造方法，用于初始化服务端
	 */
	public WebServer(){
		try {
			System.out.println("正在启动服务端...");
			server = new ServerSocket(8088);
			//初始化线程池
			threadPool = Executors.newFixedThreadPool(50); 
			System.out.println("服务端启动完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	服务端开始工作的方法
	 */
	public void start() {
		try {
			//暂时只处理客户端的一次请求，看看效果，所以while注释掉
			while(true) {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了！");
				//启动一个线程处理该客户端请求
				ClientHandler handler = new ClientHandler(socket);
				//将任务加入线程池
				threadPool.execute(handler);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}
