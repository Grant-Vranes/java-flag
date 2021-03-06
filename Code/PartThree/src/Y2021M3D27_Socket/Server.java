package Y2021M3D27_Socket;
/**
 * 	聊天室服务端
 * @author Grant·Vranes
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Server {
	/*
	 * 	运行在服务端的ServerSocket
	 * 	有两个作用
	 *	1、向系统申请服务端口，客户端就是通过这个端口与服务端
	 *	       程序建立连接的。
	 *	2、监听该端口，当客户端通过该端口与服务端建立连接时会
	 *	       自动创建一个Socket。通过这个Socket与客户端进
	 *	       行数据交互。
	 * 
	 */
	private ServerSocket server;
	
	/*
	 * 	该数组用于保存所有ClientHandler内部对应客户端
	 * 	的输出流，以便广播消息。
	 * 	由于内部类可以访问其对应外部类的属性，对此我们在
	 * 	Server中定义该数组，所有的内部类ClientHandler
	 * 	都可以看到它。这样将这些ClientHandler需要共享
	 * 	的数据存入这个数组即可。
	 */
//	private PrintWriter[] allOut = {};
	private Collection<PrintWriter> allOut = new ArrayList<PrintWriter>();
	/*
	 * 	构造方法，用于初始化服务端
	 */
	public Server() {
		try {
			/*
			 * 	实例化ServerSocket的同时向系统申请服务端口，该端口不能与
			 * 	系统申请的其他应用程序相同，否则会抛出地址被占用的异常
			 */
			System.out.println("正在启动服务端............");
			server = new ServerSocket(8088);
			System.out.println("服务端启动成功！");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	程序开始工作的方法
	 */
	public void start() {
		try {
			/*
			 * 	ServerSocket有一个重要的方法：
			 * 	Socket accept()
			 * 	该方法是一个“阻塞”方法，调用后程序就在这里“卡住了”，这是开始
			 * 	等待客户端的连接。那么当客户端通过端口尝试连接时，accept会返
			 * 	回一个Socket，通过该Socket就可以与刚建立连接的客户端进行交互了。
			 */
			while(true) {
				System.out.println("等待客户端连接......");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了！");
				//启动一个线程来处理该客户端
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//main方法
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	/*
	 * 	该线程任务是与指定的Socket对应的客户端进行数据交互
	 */
	private class ClientHandler implements Runnable{//线程的第二种创建方式
		private Socket socket;
		//记录当前客户端的地址信息
		private String host;
		
		public ClientHandler(Socket socket) {//有参构造
			this.socket = socket;
			/*
			 * 	通过Socket获取远端计算机地址信息(对于服务端而言，远端就是客户端)
			 */
			InetAddress address = socket.getInetAddress();
			host = address.getHostAddress();
		}
		
		public void run() {
			PrintWriter pw = null;
			System.out.println("启动了一个线程处理客户端");
			try {
				/*
				 * 	通过Socket获取输入流，读取客户端发送过来的数据
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
			
				/*
				 * 	通过Socket获取输出流，给该客户端发送消息
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);
				pw = new PrintWriter(bw,true);
				
				/*
				 * 	将当前ClientHandler对应客户端的输出流存入到allOut数组中。以便其它ClientHandler
				 * 	在接收消息后可以将消息发送给当前客户端
				 */
				synchronized(allOut) {
//					//1、先对allOut数组扩容
//					allOut = Arrays.copyOf(allOut, allOut.length+1);
//					//2、将当前的pw存入到数组最后一个位置上
//					allOut[allOut.length-1] = pw;
					//集合没有必要做扩容
					allOut.add(pw);
				}
				
				/*
				 * 	String readLine()
				 * 	读取一行字符串
				 * 	顺序读取若干字符，当读取到了换行符时停止，并将换行符之前的字符组成一个字符串
				 * 	返回。返回的字符串中是不含有最后的换行符的。若返回值为null，说明流读取到了末尾。
				 *	 
				 * 	while(true){
				 * 		String message = br.readLine();
				 * 		System.out.println("Client说：" + message);
				 * 	}
				 * 	上面这种写法是有错误的，while(true)是个循环，而br.readLine()读到末尾时，
				 * 	还有返回值null，循环仍在进行，这就成了一个死循环。
				 */
				String message = null;
				while((message=br.readLine()) != null) {
					System.out.println(host+"说：" + message);
					//将消息发送给当前客户端
					//pw.println("Server说："+message);
				
					/*
					 * 遍历allOut操作要和其他线程对该数组的增删互斥(互斥锁)
					 */
					synchronized(allOut) {
//						//遍历allOut，将消息发送给所有客户端
//						for(int i=0; i<allOut.length; i++) {
//							allOut[i].println("客户端说："+message);
//						}
						for(PrintWriter o : allOut) {
							o.println(host+"说:"+message);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//处理客户端断开链接后的操作
				
				synchronized(allOut) {
					//将当前客户端的输出流pw从allOut数组中删除
//					for (int i = 0; i < allOut.length; i++) {
//						if(allOut[i] == pw) {
//							//将最后一个元素放在这里
//							allOut[i] = allOut[allOut.length-1];
//							//缩容
//							allOut = Arrays.copyOf(allOut, allOut.length-1);
//							break;
//						}
//					}
					allOut.remove(pw);
				}
				
				//将socket关闭
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
