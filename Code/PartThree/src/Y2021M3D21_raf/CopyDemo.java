package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	�����ļ�����
 * 	������������еĶ�д�������������д����Ӳ���е�����
 * 	��һ������Ȼ����д��Ӳ���е���һ���ļ���ȥ���������
 * 	������Ӳ�̵Ķ̰壬�����ڸ��Ƶ�ʱ��ǳ���
 * @author Grant��Vranes
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	��������RAF��һ��������ԭ�ļ���һ�������������ļ���д��
		 * 	˳���ԭ�ļ���ȡÿ���ֽ�д�뵽�����ļ��С�
		 */
		RandomAccessFile src = new RandomAccessFile("image.JPG", "r");
		RandomAccessFile desc = new RandomAccessFile("image_cp.JPG", "rw");
		
		//��¼ÿ�ζ�ȡ�����ֽ�
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read()) != -1) {//ֱ�����꣬��src.read()=-1ʱ����
			desc.write(d);
			/*
			 * 	�мǣ�read��write�Ƕ�һ��дһ��
			 * 	�е��˿�����Ϊ
			 * while(src.read() != -1) {//ֱ�����꣬��src.read()=-1ʱ����
			 *	desc.write(src.read());
			 *	����Ҳ�ǶԵģ�ʵ�����Ǵ�ģ���һ��read����
			 *	�ж��Ƿ���꣬�ڶ������ŵ�һ�������������д��Ķ��Ǻ�һ��Ԫ��
			 */
		}
		long end = System.currentTimeMillis();
		System.out.println("�������!,��ʱ:"+(end-start)+"ms");//�������!,��ʱ:139747ms
		src.close();
		desc.close();
	}
}
