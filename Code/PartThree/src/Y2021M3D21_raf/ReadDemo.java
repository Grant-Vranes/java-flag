package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	��ȡ�ļ�����
 * @author Grant��Vranes
 *
 */
public class ReadDemo {
	public static void main(String[] args) throws IOException {
		/*
		 *	 ��ȡ��ǰĿ¼��raf.dat�ļ�����
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		/*
		 * int rand()
		 * 	��ȡһ���ֽڣ�����int��ʽ����
		 * 	������ֵΪ-1�����ʾ��ȡ�����ļ�ĩβ
		 */
		int d = raf.read();
		System.out.println(d);
		raf.close();
	}
}
