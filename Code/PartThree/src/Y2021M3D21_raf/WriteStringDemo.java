package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	д���ַ�������
 * @author Grant��Vranes
 *
 */
public class WriteStringDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		String line = "��Һ�!";
		/*
		 * String�ṩ��ת��Ϊ2���Ƶķ���:
		 * byte[] getBytes();
		 */
//		byte[] data = line.getBytes();//���Ƽ��޲εģ��Ժ����������̵�ʱ��ܿ����ַ�����ƥ����ɵ�����
		byte[] data = line.getBytes("UTF-8");//ָ���ַ���,UTF-8һ���ַ�ռ3���ֽ�
		
		raf.write(data);
		System.out.println("д�����");
		raf.close();
	}
}
