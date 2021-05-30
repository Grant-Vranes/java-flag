package com.webserver.core;
//����������ʢ����һ�˳�ɡ������
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *	��ҳ������http://localhost:8088/myweb/index.html
 * 	WebServer����
 * @author Grant��Vranes
 *
 */
public class WebServer {
	private ServerSocket server;
	private ExecutorService threadPool;//�����̳߳�
	
	/*
	 * 	���췽�������ڳ�ʼ�������
	 */
	public WebServer(){
		try {
			System.out.println("�������������...");
			server = new ServerSocket(8088);
			//��ʼ���̳߳�
			threadPool = Executors.newFixedThreadPool(50); 
			System.out.println("������������");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	����˿�ʼ�����ķ���
	 */
	public void start() {
		try {
			//��ʱֻ�����ͻ��˵�һ�����󣬿���Ч��������whileע�͵�
			while(true) {
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();
				System.out.println("һ���ͻ��������ˣ�");
				//����һ���̴߳����ÿͻ�������
				ClientHandler handler = new ClientHandler(socket);
				//����������̳߳�
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