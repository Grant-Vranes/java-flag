package Y2021M3D27_Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 	聊天室客户端
 * @author Grant·Vranes
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * 	Socket封装了TCP协议的通讯细节，使该过程抽象为通过两个
	 * 	流的读写完成与远端计算机的数据交互。
	 * 
	 * 	Socket的本地翻译为：套接字
	 */
	private Socket socket;
	
	/*
	 * 	构造方法，用来初始化客户端
	 */
	public Client() {
		try {
			/*
			 * 	实例化Socket的同时需要传入两个参数：
			 * 	1、服务端的IP地址
			 * 	2、服务端所使用的端口号
			 * 
			 * 	通过IP地址可以找到服务端的计算机，通过端口可以连接
			 * 	到运行在服务端计算机上的服务端应用程序。而我们客户端
			 * 	自身的IP和端口无需指定，系统会分配一个端口，并且连
			 * 	接后会发送给服务端。
			 * 
			 * 	实例化Socket的过程就是发起连接的过程，若服务端没有
			 * 	响应则这里会直接抛出异常。
			 */
			System.out.println("正在连接服务端.........");
			socket = new Socket("localhost",8088);
			System.out.println("已连接服务端!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	程序开始工作的方法
	 */
	public void start() {
		try {
			//启动一个线程用来读取服务端消息
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			Scanner scanner = new Scanner(System.in);
			/*
			 * Socket提供的方法：
			 * OutputStream getOutputStream()
			 * 	返回一个字节输出流，通过该输出流写出的数据最终会发送给服务端
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);
			
			String line = null;
			while(true) {
				line = scanner.nextLine();
				pw.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//main方法
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
	
	/*
	 * 	该线程负责循环接受服务端发送过来的消息并输出到客户端
	 * 	的控制台
	 */
	private class ServerHandler implements Runnable{
		public void run() {
			try {
				/*
				 * 	通过Socket获取输入流，读取服务端发送过来的消息
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String line = null;
				while((line=br.readLine())!=null) {
					System.out.println(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
