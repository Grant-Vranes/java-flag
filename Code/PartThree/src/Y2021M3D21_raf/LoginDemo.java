package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *	 ��ɵ�¼����
 * @author Grant��Vranes
 *
 */
public class LoginDemo {
	public static void main(String[] args) throws IOException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��¼ҳ��\n�������û���:");
		String userName = scanner.nextLine();
		System.out.println("��������:");
		String password = scanner.nextLine();
		
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "r");
		boolean flag = false;
		
		for (int i = 0; i < raf.length()/100; i++) {
			//�Ƚ�ָ���ƶ���������¼�Ŀ�ʼλ��
			raf.seek(i*100);
			//��ȡ�û���
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"UTF-8").trim();//��ȡ���ļ��е��û���
			raf.seek(i*100+32);//�ƶ��������λ��
			raf.read(data);
			String pwd = new String(data,"UTF-8").trim();//��ȡ����
			if(userName.equals(name) && password.equals(pwd)) {
				
				System.out.println("��¼�ɹ���");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("�û��������벻��ȷ��");
		}
		raf.close();
	}
}
