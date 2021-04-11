package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 	����û�ע�Ṧ��
 * 	����ʼ��Ҫ���û����룺
 * 	�û��������룬�ǳƣ�����
 * 
 * 	���ü�¼д�뵽user.dat�ļ��С�
 * 	�����û��������룬�ǳ�Ϊ�ַ���������Ϊһ��intֵ
 * 
 * 	ÿ����¼ռ��100�ֽڣ����У��û��������룬�ǳ�Ϊ�ַ���
 * 	��ռ32�ֽڣ�����Ϊintռ��4�ֽ�
 * @author Grant��Vranes
 *
 */
public class RegDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("��ӭע��");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�������û�����");
		String userName = scanner.nextLine();
		
		System.out.println("���������룺");
		String password = scanner.nextLine();
		
		System.out.println("�������ǳƣ�");
		String nickName = scanner.nextLine();
		
		System.out.println("���������䣺");
		int age = Integer.parseInt(scanner.nextLine());
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		/*	ÿ��ִ�г����ʱ��ָ�붼�ڿ�ͷ�������ÿдһ��֮ǰд�ľͻᱻ����
		 *	����ÿһ�ε��ó����ض�ָ���λ�ã�ʹ�����ĩβ,���ź���д
		 */
		raf.seek(raf.length());
		
		//д�û���
		//1�Ƚ��û���ת�ɶ�Ӧ��һ���ֽ�
		byte[] data = userName.getBytes("UTF-8");
		//2������������Ϊ32�ֽ�
		data = Arrays.copyOf(data, 32);
		//3�����ֽ�����һ����д���ļ�
		raf.write(data);
		
		//д����
		data = password.getBytes("UTF-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		
		//д�ǳ�
		data = nickName.getBytes("UTF-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		
		//д����
		raf.writeInt(age);
		
		System.out.println("ע�����");
		raf.close();
		
		
		
	}
}