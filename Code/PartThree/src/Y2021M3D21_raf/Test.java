package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 	��ɼ��׼��±�����
 * 	����������Ҫ���û������ļ�����Ȼ��ʹ��RAF�Ը��ļ���д����
 * 	֮���û��ڿ���̨�����ÿ���ַ�����д�뵽���ļ��С�
 * 	���û������ˡ�exit��ʱ�������˳�
 * @author Grant��Vranes
 *
 */
public class Test {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����ļ���:");
		String fileName = scanner.nextLine();
		
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		
		System.out.println("�뿪ʼ�������ݣ�");
		String line = "";
		while(true) {
			line = scanner.nextLine();
			if("exit".equals(line)) {
				/*
				 * 	ע�⣺
				 * 	��Ϊ��� ����.equals(������) ����д��������Ϊnullʱ�ͻᱨ��ָ���쳣
				 * 	��������������ȥequals��ʱ���Ƽ��� ������.equals(����)
				 * 	�����������ΪnullҲ�������
				 */
				break;
			}
//			byte[] data = line.getBytes("UTF-8");
//			raf.write(data);
			raf.write(line.getBytes("UTF-8"));
		}
		System.out.println("bye");
		raf.close();
	}
	
}
