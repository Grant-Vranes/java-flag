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
 * 	�����ҿͻ���
 * @author Grant��Vranes
 *
 */
public class Client {
	/*
	 * java.net.Socket
	 * 	Socket��װ��TCPЭ���ͨѶϸ�ڣ�ʹ�ù��̳���Ϊͨ������
	 * 	���Ķ�д�����Զ�˼���������ݽ�����
	 * 
	 * 	Socket�ı��ط���Ϊ���׽���
	 */
	private Socket socket;
	
	/*
	 * 	���췽����������ʼ���ͻ���
	 */
	public Client() {
		try {
			/*
			 * 	ʵ����Socket��ͬʱ��Ҫ��������������
			 * 	1������˵�IP��ַ
			 * 	2���������ʹ�õĶ˿ں�
			 * 
			 * 	ͨ��IP��ַ�����ҵ�����˵ļ������ͨ���˿ڿ�������
			 * 	�������ڷ���˼�����ϵķ����Ӧ�ó��򡣶����ǿͻ���
			 * 	������IP�Ͷ˿�����ָ����ϵͳ�����һ���˿ڣ�������
			 * 	�Ӻ�ᷢ�͸�����ˡ�
			 * 
			 * 	ʵ����Socket�Ĺ��̾��Ƿ������ӵĹ��̣��������û��
			 * 	��Ӧ�������ֱ���׳��쳣��
			 */
			System.out.println("�������ӷ����.........");
			socket = new Socket("localhost",8088);
			System.out.println("�����ӷ����!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 	����ʼ�����ķ���
	 */
	public void start() {
		try {
			Scanner scanner = new Scanner(System.in);
			/*
			 * Socket�ṩ�ķ�����
			 * OutputStream getOutputStream()
			 * 	����һ���ֽ��������ͨ���������д�����������ջᷢ�͸������
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);
			
			/*
			 * 	ͨ��Socket��ȡ����������ȡ����˷��͹�������Ϣ
			 */
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while(true) {
				line = scanner.nextLine();
				pw.println(line);
				
				//��ȡ����˷��͹�����һ���ַ���
				line = br.readLine();
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
}