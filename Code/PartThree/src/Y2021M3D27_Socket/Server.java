package Y2021M3D27_Socket;
/**
 * 	�����ҷ����
 * @author Grant��Vranes
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	/*
	 * 	�����ڷ���˵�ServerSocket
	 * 	����������
	 *	1����ϵͳ�������˿ڣ��ͻ��˾���ͨ������˿�������
	 *	       ���������ӵġ�
	 *	2�������ö˿ڣ����ͻ���ͨ���ö˿������˽�������ʱ��
	 *	       �Զ�����һ��Socket��ͨ�����Socket��ͻ��˽�
	 *	       �����ݽ�����
	 * 
	 */
	private ServerSocket server;
	
	/*
	 * 	���췽�������ڳ�ʼ�������
	 */
	public Server() {
		try {
			/*
			 * 	ʵ����ServerSocket��ͬʱ��ϵͳ�������˿ڣ��ö˿ڲ�����
			 * 	ϵͳ���������Ӧ�ó�����ͬ��������׳���ַ��ռ�õ��쳣
			 */
			System.out.println("�������������............");
			server = new ServerSocket(8088);
			System.out.println("����������ɹ���");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	����ʼ�����ķ���
	 */
	public void start() {
		try {
			/*
			 * 	ServerSocket��һ����Ҫ�ķ�����
			 * 	Socket accept()
			 * 	�÷�����һ�������������������ú������������ס�ˡ������ǿ�ʼ
			 * 	�ȴ��ͻ��˵����ӡ���ô���ͻ���ͨ���˿ڳ�������ʱ��accept�᷵
			 * 	��һ��Socket��ͨ����Socket�Ϳ�����ս������ӵĿͻ��˽��н����ˡ�
			 */
			System.out.println("�ȴ��ͻ�������......");
			Socket socket = server.accept();
			System.out.println("һ���ͻ��������ˣ�");
			//����һ���߳��������ÿͻ���
			ClientHandler handler = new ClientHandler(socket);
			Thread t= new Thread(handler);
			t.start();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	/*
	 * 	�ý�����������ָ����Socket��Ӧ�Ŀͻ��˽������ݽ���
	 */
	private class ClientHandler implements Runnable{
		private Socket socket;
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
			System.out.println("������һ���̴߳����ͻ���");
			try {
				/*
				 * 	ͨ��Socket��ȡ����������ȡ�ͻ��˷��͹���������
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
			
				/*
				 * 	ͨ��Socket��ȡ����������ÿͻ��˷�����Ϣ
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);
				PrintWriter pw = new PrintWriter(bw,true);
				
				
				
				/*
				 * 	String readLine()
				 * 	��ȡһ���ַ���
				 * 	˳���ȡ�����ַ�������ȡ���˻��з�ʱֹͣ���������з�֮ǰ���ַ����һ���ַ���
				 * 	���ء����ص��ַ������ǲ��������Ļ��з��ġ�������ֵΪnull��˵������ȡ����ĩβ��
				 *	 
				 * 	while(true){
				 * 		String message = br.readLine();
				 * 		System.out.println("Client˵��" + message);
				 * 	}
				 * 	��������д�����д���ģ�while(true)�Ǹ�ѭ������br.readLine()����ĩβʱ��
				 * 	���з���ֵnull��ѭ�����ڽ��У���ͳ���һ����ѭ����
				 */
				String message = null;
				while((message=br.readLine()) != null) {
					System.out.println("Client˵��" + message);
					//����Ϣ���͸���ǰ�ͻ���
					pw.println("Server˵��"+message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}